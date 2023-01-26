/*
 * ATTENTION: The "eval" devtool has been used (maybe by default in mode: "development").
 * This devtool is neither made for production nor for readable output files.
 * It uses "eval()" calls to create a separate source file in the browser devtools.
 * If you are trying to read the output file, select a different devtool (https://webpack.js.org/configuration/devtool/)
 * or disable the default devtool with "devtool: false".
 * If you are looking for production-ready output files, see mode: "production" (https://webpack.js.org/configuration/mode/).
 */
/******/ (() => { // webpackBootstrap
/******/ 	"use strict";
/******/ 	var __webpack_modules__ = ({

/***/ "./newes6module2/1.js":
/*!****************************!*\
  !*** ./newes6module2/1.js ***!
  \****************************/
/***/ ((__unused_webpack_module, exports) => {

eval("\n\nObject.defineProperty(exports, \"__esModule\", ({\n    value: true\n}));\n//定义哪些方法可以被其他js调用\n\n\n/**\n *  写法1：export function 方法名(){}\n*/\n\n// export function getList(){\n//     console.log(\"function getList running\")\n// }\n\n// export function sum(a,b){\n//     return parseInt(a) + parseInt(b)\n// }\n\n/**\n *  写法2 ：  \n *       export default {\n *              方法名(){},\n *              方法名(){}\n *       }\n *     注意：↑ 这里没有function关键字\n */\n\nexports[\"default\"] = {\n    getList: function getList() {\n        console.log(\"getList function running.......\");\n    },\n    sum: function sum(a, b) {\n        return parseInt(a) + parseInt(b);\n    }\n};\n\n//# sourceURL=webpack://moduledemo/./newes6module2/1.js?");

/***/ }),

/***/ "./newes6module2/2.js":
/*!****************************!*\
  !*** ./newes6module2/2.js ***!
  \****************************/
/***/ ((__unused_webpack_module, __unused_webpack_exports, __webpack_require__) => {

eval("\n\nvar _ = __webpack_require__(/*! ./1.js */ \"./newes6module2/1.js\");\n\nvar _2 = _interopRequireDefault(_);\n\nfunction _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }\n\n//调用方法\n\n/**\r\n * 写法1\r\n */\n// getList()\n// console.log(sum())\n\n\n/**\r\n * 写法2  通过类似 “对象.方法”的方式调用\r\n */\n\n_2.default.getList(); //Es6写法实现的模块化操作，在node.js中不能直接运行（只是模块化操作不能运行）\n//需要使用babel转换成es5才能在node.js中才能用\n\n//引入1.js文件，注意语法与es5的区别\n\n//写法1\n// import { getList,sum } from \"./1\";\n\n//写法2\n\nconsole.log(_2.default.sum(1, 3));\n\n//# sourceURL=webpack://moduledemo/./newes6module2/2.js?");

/***/ })

/******/ 	});
/************************************************************************/
/******/ 	// The module cache
/******/ 	var __webpack_module_cache__ = {};
/******/ 	
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/ 		// Check if module is in cache
/******/ 		var cachedModule = __webpack_module_cache__[moduleId];
/******/ 		if (cachedModule !== undefined) {
/******/ 			return cachedModule.exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = __webpack_module_cache__[moduleId] = {
/******/ 			// no module.id needed
/******/ 			// no module.loaded needed
/******/ 			exports: {}
/******/ 		};
/******/ 	
/******/ 		// Execute the module function
/******/ 		__webpack_modules__[moduleId](module, module.exports, __webpack_require__);
/******/ 	
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/ 	
/************************************************************************/
/******/ 	
/******/ 	// startup
/******/ 	// Load entry module and return exports
/******/ 	// This entry module can't be inlined because the eval devtool is used.
/******/ 	var __webpack_exports__ = __webpack_require__("./newes6module2/2.js");
/******/ 	
/******/ })()
;