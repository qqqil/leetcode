import math
import random
import string

random.seed(0)

## calculate a randomw number 
def rand(a,b):
    return (b-a)*random.random() + a
## make a matrix 
def makeMatrix(I,J,fill=0.0):
    m=[]
    for i in range(I):
        m.append([fill]*J)
    return m

## sigmoid 
def dsigmoid(x):
    return 1 /(1 + math.exp(-x))

class NN:
    def __init__(self,ni,nh,no):
        # number of input,hiden,and output nodes 
        self.ni = ni +1 # +1 for bias node 
        self.nh = nh
        self.no = no

        ## activations for nodes
        self.ai = [1.0] * self.ni
        self.ah = [1.0] * self.nh 
        self.ao = [1.0] * self.no

        self.ahi = [1.0] * self.nh
        
        self.aoi = [1.0] * self.no
        # self.aoo = [1.0] * self.no

        ## weights 
        self.wi = makeMatrix(self.ni,self.nh)
        self.wo = makeMatrix(self.nh,self.no)

        ## set them to random values 
        for i in range(self.ni):
            for j in range(self.nh):
                self.wi[i][j] = rand(-2.0,2.0)
        
        ## last change in weights for momentum 
        self.ci = makeMatrix(self.ni,self.nh)
        self.co = makeMatrix(self.nh,self.no)

    # update node value of nn
    def update(self,inputs):
        if len(inputs) != self.ni -1:
            raise ValueError('wrong number of inputs')
        # input activations 

        for i in range(self.ni -1):
            #self.ai[i] = dsigmoid(inputs[i])
            self.ai[i] = inputs[i]

        # hidden activations 
        for j in range(self.nh):
            sum = 0.0 
            for i in range(self.ni):
                sum = sum + self.ai[i]* self.wi[i][j]
            self.ahi[j] = sum
            self.ah[j] = dsigmoid(sum)

        # output activitions 
        for k in  range(self.no):
            sum = 0.0 
            for j in range(self.nh):
                sum = sum + self.ah[j] * self.wo[j][k]
            self.aoi[k] = sum
            self.ao[k] = dsigmoid(sum)
        return self.ao[:]

    # update weights 
    def backPropagate(self,targets,N,M):
        if len(targets) != self.no:
            raise ValueError('wrong number of targets values')
        # calculate grident for  for output
        # output_deltas = [0.0] * self.no 
        gix = [0.0] * self.no
        for k in range(self.no):
            error = targets[k] - self.ao[k]
            gix[k] = self.ao[k] * (1 - self.ao[k]) * (targets[k] - self.ao[k])
            

            #output_deltas[k] = dsigmoid(self.ao[k]) * error 
        ## update output weights 
        ## delta_wj = -1 * rate * y'(1- y')(y' -y) * bh

        
        # update output weights
        delta_whj = makeMatrix(self.nh,self.no)

        for i in range(self.nh):
            for j in range(self.no):
                bh = self.ahi[i]
                gj = gix[j]
                delta_whj[i][j] = N *gj * bh

        # update hidden weights 
        # delta_wi = -1 * rate * eh * xi 
        # = -1 * rate *bh * (1- bh) *sum(whjgj)
        ehx = [0.0] * self.nh 
        for i in range(self.nh):
            sum = 0.0
            for j in range(self.no):
                sum = sum+ self.wo[i][j] * gix[j]
            ehx[i] = self.ah[i] * (1 - self.ah[i]) * sum

        delta_vih = makeMatrix(self.ni,self.nh)

        for i in range(self.ni):
            for j in range(self.nh):
                delta_vih[i][j] = N * ehx[j] * self.ai[i]

        # update output weights 
        for i in range(self.nh):
            for j in range(self.no):
                self.wo[i][j] = self.wo[i][j] + delta_whj[i][j]

        # update input weights 
        for i in range(self.ni):
            for j in range(self.nh):
                self.wi[i][j] = self.wi[i][j] + delta_vih[i][j]

        # calculate error 
        error = 0.0 
        
        for k in  range(len(targets)):
            error = error + 0.5* (targets[k] - self.ao[k])**2
        return error
    
    def test(self,patterns):
        for p in patterns:
            print(p[0],'->',self.update(p[0]))
    
    def weights(self):
        print('input weights:')
        for i in range(self.ni):
            print(self.wi[i])
        
        print('output weights:')
        for j in range(self.nh):
            print(self.wo[j])

    def train(self,patterns,iterations=1000,N=0.5,M=0.1):
        #N :learning rate 
        #M : momentum factor 

        for i in range(iterations):
            error = 0.0 
            for p in patterns:
                inputs = p[0]
                targets =p[1]
                self.update(inputs)
                error = error + self.backPropagate(targets,N,M)
                print("-----input -----")
                print('{0} -> {1} {2}'.format(inputs ,self.ao,targets))
                # print("-----targets -----")
                # print(targets)
                # print('-----output of nn-----')
                # print(self.ao)

                print('-----------input weights-------')
                print(self.wi)
                print('-----------output weights-------')
                print(self.wo)
            if i% 100 == 0:
                print( 'error %-.5f' %error)
def demo():
    # teach network xor function 
    pat=[
        [[0,0],[0]],
        [[0,1],[1]],
        [[1,0],[1]],
        [[1,1],[0]]
        # [[1,2],[3]],
        # [[1,4],[5]],
        # [[3,5],[8]],
        # [[1,8],[9]],
        # [[9,12],[21]],
        # [[5,7],[12]]

    ]

    #create network with two inputs two hidden ,and one output nodes 
    n = NN(2,2,1)

    #train it
    n.train(pat)

    # test it 
    pat2=[
        [[0,1],[1]]

    ]
    n.test(pat2)
print( 'bpnn test')
    
if __name__ =='__main__':
    demo()
