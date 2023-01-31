import request from "@/utils/request"

export default {
    //1. 获取教师列表
    getTeacherList(current,limit,teacherQuery){
        return request({
            // url:'/service/edu-teacher/pageTeacherCondition/'+current+'/'+limit,
            url:`/service/edu-teacher/pageTeacherCondition/${current}/${limit}`,
            method:'post',
            //teacherQuery条件对象，后端使用responseBody获取数据
            //data表示把对象转换json进行传递到接口里面
            data:teacherQuery
        })
    },

    //2. 添加教师
    addTeacher(teacher){
        return request({
            url:`/service/edu-teacher/addTeacher`,
            method:'post',
            data:teacher
        })
    },

    //3.根据id删除讲师
    teacherDeleteById(id){
        return request({
            url:`service/edu-teacher/${id}`,
            method:"delete"
        })
    },

    //4.根据id查找教师信息
    getTeacherById(id){
        return request({
            url:`service/edu-teacher/getTeacher/${id}`,
            method:'get'
        })
    },
    //5.修改教师
    updateTeacher(teacher){
        return request({
            url:`service/edu-teacher/modify`,
            data:teacher,
            method:'post'
        })
    }

}


// export function getTeacherList(param){

//     return request({
//         url:'',

//     })
//     // return request({
//     //     url: '/service/user/login',
//     //     method: 'get',
//     //     data: {
//     //       username,
//     //       password
//     //     }
//     //   })
// }

