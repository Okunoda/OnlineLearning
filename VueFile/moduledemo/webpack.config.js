const path = require("path")//node.js内置模块
module.exports={
    entry:'./newes6module2/2.js',//配置文件入口
    output:{
        path:path.resolve(__dirname,'./dist'),//输出路径，__dirname表示当且文件所在路径
        filename:'bundle.js'//输出文件
    },
    module:{
        rules:[
            {
                test:'/\.css$/',//打包规则应用到以css结尾的文件
                use:['style-loader','css-loader']
            }
        ]
    }
}