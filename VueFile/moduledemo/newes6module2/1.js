"use strict";

Object.defineProperty(exports, "__esModule", {
    value: true
});
//定义哪些方法可以被其他js调用


/**
 *  写法1：export function 方法名(){}
*/

// export function getList(){
//     console.log("function getList running")
// }

// export function sum(a,b){
//     return parseInt(a) + parseInt(b)
// }

/**
 *  写法2 ：  
 *       export default {
 *              方法名(){},
 *              方法名(){}
 *       }
 *     注意：↑ 这里没有function关键字
 */

exports.default = {
    getList: function getList() {
        console.log("getList function running.......");
    },
    sum: function sum(a, b) {
        return parseInt(a) + parseInt(b);
    }
};