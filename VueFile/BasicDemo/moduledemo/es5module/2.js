//调用1.js中的方法
//1.引入1.js文件
//这里的one类似java中的对象
const one = require('./1.js')// "./" 不能省略，表示当前路径

//2.调用
console.log(one.sum(3,3))
console.log(one.mul(3,3))

