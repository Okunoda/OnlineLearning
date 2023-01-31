//定义方法
const sum = function(a,b){
    return a+b;
}

const sub = function(a,b){
    return parseInt(a)-parseInt(b)
}

const mul = function(a,b){
    return parseInt(a)*parseInt(b)
}

const div = function(a,b){
    return parseInt(a)/parseInt(b)
}

//设置哪些方法可以被别的js调用
module.exports = {
    sum,
    sub,
    div,
}