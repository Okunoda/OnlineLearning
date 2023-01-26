"use strict";

var _ = require("./1");

//调用方法
(0, _.getList)(); //Es6写法实现的模块化操作，在node.js中不能直接运行（只是模块化操作不能运行）
//需要使用babel转换成es5才能在node.js中才能用

//引入1.js文件，注意语法与es5的区别

console.log((0, _.sum)(1,2));