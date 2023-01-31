"use strict";

var _ = require("./1.js");

var _2 = _interopRequireDefault(_);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

//调用方法

/**
 * 写法1
 */
// getList()
// console.log(sum())


/**
 * 写法2  通过类似 “对象.方法”的方式调用
 */

_2.default.getList(); //Es6写法实现的模块化操作，在node.js中不能直接运行（只是模块化操作不能运行）
//需要使用babel转换成es5才能在node.js中才能用

//引入1.js文件，注意语法与es5的区别

//写法1
// import { getList,sum } from "./1";

//写法2

console.log(_2.default.sum(1, 3));