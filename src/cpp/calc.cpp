double calc(string expr) {
        stack<double> st;   
    stack<char> st_exprs;   
    set<char> expr_set = {'+', '-', '*',
                          '/'}; 
       map<char, int> priories;    priories['+'] = 1;    priories['-'] = 1;    priories['*'] = 2;    priories['/'] = 2;    string tmp;    for (const char ch :expr) {
                if (expr_set.find(ch) == expr_set.end()) {             tmp += ch;        } else {
                        st.push(atof(tmp.c_str()));            tmp = "";            if (st_exprs.empty()) {
                                st_exprs.push(ch);                continue;           
            }            char old_expr = st_exprs.top();            if (priories[old_expr] > priories[ch]) {
                                double val1 = st.top();                st.pop();                double val2 = st.top();                st.pop();                double ret = _calc(
                        val1, val2, old_expr);                st.push(ret);                st_exprs.pop();           
            }            st_exprs.push(ch);       
        }   
    }    st.push(atof(tmp.c_str()));    cout << "number stack size:" << st.size() <<
                                        endl;    while (!st_exprs.empty()) {
                char expr = st_exprs.top();        double val1 = st.top();        st.pop();        double val2 = st.top();        st.pop();        double ret = _calc(
                val2, val1, expr);        st.push(ret);        st_exprs.pop();   
    }    return st.top();
}

void test_calc() {     string expr = "1+2*3+5*9/3";    double rtn = calc(expr);    cout << rtn << endl; }
