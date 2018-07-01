import matplotlib.pyplot as plt
import numpy as np
import wave
import sys
import math
import contextlib
from numpy import fft as fft
from scipy.io import wavfile




work_dir =r'/home/andy/tmp/'
path =r'/home/andy/tmp/introduction.wav'

fname =work_dir+ 'introduction.wav'
outname = work_dir+'filtered-talk.wav'

def plot_freq(path):
    with wave.open(path,'rb') as wr:
        print(wr.getparams())
        da =np.fromstring(wr.readframes(-1),dtype=np.uint8)
        nframe = wr.getnframes()
        lf = np.fft.rfft(da)
        plt.figure(1)
        a = plt.subplot(211)
        r = 2**8
        a.set_ylim([0, r])
        a.set_xlabel('time [s]')
        a.set_ylabel('sample value [-]')
        x = np.arange(nframe)/nframe
        plt.plot(x, da)
        b = plt.subplot(212)
        b.set_ylim([0,5000])
        b.set_xscale('log')
        b.set_xlabel('frequency [Hz]')
        b.set_ylabel('|amplitude|')
        plt.plot(abs(lf))

        plt.show()

plot_freq(fname)
spf = wave.open(path,'rb')
print(spf.getparams())
sz = spf.getframerate()
nframe = spf.getnframes()




# ns = np.column_stack((nl)).ravel().astype(np.uint8)
ww = wave.open(outname, 'w')
par = list(spf.getparams())
par[3] =0
ww.setparams(tuple(par)) # Use the same parameters as the input file.

lowpass = 80
higpass =255

c = int(spf.getnframes()/sz) # whole file
spf.rewind()
for num in range(c):
    print('Processing {}/{} s'.format(num+1, c))
    da = np.fromstring(spf.readframes(sz), dtype=np.uint8)
    # left, right = da[0::2], da[1::2] # left and right channel
    lf = np.fft.rfft(da)
    lf[:lowpass]= 0 # low pass filter
    lf[55:66]= 0 # line noise
    lf[higpass:]= 0 # high pass filter
    plt.plot(abs(lf))
    plt.show()
    ns= np.fft.irfft(lf)
    # left, right = da[0::2], da[1::2] # left and right channel
    # lf, rf = np.fft.rfft(left), np.fft.rfft(right)
    # lf[:lowpass], rf[:lowpass] = 0, 0 # low pass filter
    # lf[55:66], rf[55:66] = 0, 0 # line noise
    # lf[higpass:], rf[higpass:] = 0,0 # high pass filter
    # nl, nr = np.fft.irfft(lf), np.fft.irfft(rf)
    # ns = np.column_stack((nl,nr)).ravel().astype(np.uint8)
    # ns = np.column_stack((nl)).ravel().astype(np.uint8)
    ww.writeframes(ns.tostring())
# Close the files.
spf.close()
ww.close()
plot_freq(outname)



cutOffFrequency = 400.0

# from http://stackoverflow.com/questions/13728392/moving-average-or-running-mean
def running_mean(x, windowSize):
  cumsum = np.cumsum(np.insert(x, 0, 0)) 
  return (cumsum[windowSize:] - cumsum[:-windowSize]) / windowSize

# from http://stackoverflow.com/questions/2226853/interpreting-wav-data/2227174#2227174
def interpret_wav(raw_bytes, n_frames, n_channels, sample_width, interleaved = True):

    if sample_width == 1:
        dtype = np.uint8 # unsigned char
    elif sample_width == 2:
        dtype = np.int16 # signed 2-byte short
    else:
        raise ValueError("Only supports 8 and 16 bit audio formats.")

    channels = np.fromstring(raw_bytes, dtype=dtype)

    if interleaved:
        # channels are interleaved, i.e. sample N of channel M follows sample N of channel M-1 in raw data
        channels.shape = (n_frames, n_channels)
        channels = channels.T
    else:
        # channels are not interleaved. All samples from channel M occur before all samples from channel M-1
        channels.shape = (n_channels, n_frames)

    return channels


with contextlib.closing(wave.open(fname,'rb')) as spf:
    sampleRate = spf.getframerate()
    ampWidth = spf.getsampwidth()
    nChannels = spf.getnchannels()
    nFrames = spf.getnframes()
    params = spf.getparams()
    print(params)
    print("sampleRate:%d,ampWidth:%d,nChannels:%d,nFrames:%d" %(sampleRate,ampWidth,nChannels,nFrames))



    # Extract Raw Audio from multi-channel Wav File
    signal = spf.readframes(nFrames*nChannels)
    spf.close()
    channels = interpret_wav(signal, nFrames, nChannels, ampWidth, True)

    # get window size
    # from http://dsp.stackexchange.com/questions/9966/what-is-the-cut-off-frequency-of-a-moving-average-filter
    freqRatio = (cutOffFrequency/sampleRate)
    N = int(math.sqrt(0.196196 + freqRatio**2)/freqRatio)

    # Use moviung average (only on first channel)
    filtered = running_mean(channels[0], N).astype(channels.dtype)

    wav_file = wave.open(outname, "w")
    wav_file.setparams((1, ampWidth, sampleRate, nFrames, spf.getcomptype(), spf.getcompname()))
    wav_file.writeframes(filtered.tobytes('C'))
    wav_file.close()
