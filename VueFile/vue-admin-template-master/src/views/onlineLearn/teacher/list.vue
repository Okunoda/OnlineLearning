<template>
    <div class="app-container">


        <!--查询表单-->
        <el-form :inline="true" class="demo-form-inline">
            <el-form-item>
                <el-input v-model="teacherQuery.name" placeholder="讲师名" />
            </el-form-item>
            <el-form-item>
                <el-select v-model="teacherQuery.level" clearable placeholder="讲师头衔">
                    <el-option :value="1" label="讲师" />
                    <el-option :value="2" label="副教授" />
                    <el-option :value="2" label="教授" />
                </el-select>
            </el-form-item>

            <el-form-item label="添加时间">
                <el-date-picker v-model="teacherQuery.begin" type="datetime" placeholder="选择入职时间"
                    value-format="yyyy-MM-dd HH:mm:ss" default-time="00:00:00" />
            </el-form-item>

            <el-form-item>
                <el-date-picker v-model="teacherQuery.end" type="datetime" placeholder="选择截止时间"
                    value-format="yyyy-MM-dd HH:mm:ss" default-time="00:00:00" />
            </el-form-item>

            <el-button type="primary" icon="el-icon-search" @click="getTeacherList()">查询</el-button>
            <el-button type="default" @click="resetData()">清空</el-button>
        </el-form>


        <el-table :data="list" style="width: 100%" v-loading="loading" element-loading-text="数据加载中" fit border
            highlight-current-row>

            <el-table-column type="expand">
                <template slot-scope="props">
                    <el-form label-position="left" inline class="expand-style">
                        <el-form-item label="职工名称">
                            <span>{{ props.row.name }}</span>
                        </el-form-item>
                        <el-form-item label="所属学院">
                            <span>{{ props.row.courage }}</span>
                        </el-form-item>
                        <el-form-item label="职工号">
                            <span>{{ props.row.id }}</span>
                        </el-form-item>
                        <!-- <el-form-item label="学院 ID">
                            <span>{{ props.row.collegeId }}</span>
                        </el-form-item> -->
                        <el-form-item label="简介">
                            <span>{{ props.row.intro }}</span>
                        </el-form-item>
                    </el-form>
                </template>
            </el-table-column>

            <el-table-column label="序号" width="70" align="center">
                <template slot-scope="scope">
                    {{ (page - 1) * limit + scope.$index + 1 }}
                </template>
            </el-table-column>

            <el-table-column label="职工号" prop="id" align="center">
            </el-table-column>
            <el-table-column label="职工姓名" prop="name" align="center">
            </el-table-column>

            <el-table-column label="职位" prop="level" width="120" align="center">
                <template slot-scope="scope">
                    <div v-if="scope.row.level == 1">讲师</div>
                    <div v-else-if="scope.row.level == 2">副教授</div>
                    <div v-else>教授</div>
                </template>
            </el-table-column>

            <el-table-column label="入职时间" prop="gmtCreate" align="center" width="160">
            </el-table-column>

            <el-table-column label="操作" width="200" align="center">
                <template slot-scope="scope">
                    <router-link :to="'/teacher/edit/'+scope.row.id">
                        <el-button size="mini" type="primary" round icon="el-icon-edit"
                        >编辑</el-button>
                    </router-link>
                    
                    <el-button size="mini" type="danger" round icon="el-icon-delete"
                        @click="open(scope.row.id)">删除</el-button>
                </template>
            </el-table-column>

        </el-table>

        <span style="line-height: 28px; font-size:15px" align="right">
            共{{ total }}条记录 第{{ page }}/{{ Math.ceil(total / limit) }}页
        </span>
        <el-pagination align="center" :current-page="page" :page-size="limit" background
            layout="prev, pager, next,jumper" @current-change="getTeacherList" :total="total">
        </el-pagination>

    </div>
</template>

<!-- 每行展开按键的样式 -->
<style>
.expand-style {
    font-size: 0;
}

.expand-style label {
    width: 90px;
    color: #99a9bf;
}

.expand-style .el-form-item {
    margin-right: 0;
    margin-bottom: 0;
    width: 50%;
}
</style>

<script>
// 引入api中的文件
import teacher from '@/api/teacher'

export default {
    //写核心代码部分，new Vue已经在main.js中写了，提供方法给他调用即可
    data() { //定义当前页面使用的变量和初始值
        return {
            //变量名可以不与api中的参数名相同，这里是自定义的
            list: null,
            page: 1, //当前页
            limit: 5,
            total: 0,
            teacherQuery: {},//条件封装对象，与java不一样的是，即便对象里面没有定义某个属性，在使用的时候也可以用，并且js会自动将其加入对象中
            loading:true
        }
    },
    created() {
        this.getTeacherList()
    },
    methods: {
        //page参数表示，不传参数page默认为1，传入参数就按照具体参数来运行
        //element-ui会自动调用方法传入参数
        getTeacherList(page=1) {
            this.page = page
            teacher.getTeacherList(this.page, this.limit, this.teacherQuery).then(response => {
                //response是接口返回的数据
                this.list = response.data.rows
                this.total = response.data.total
                this.loading=false
            }).catch(error => {
                console.log(error)
            })
        },
        resetData(){
            //因为在输入框输入的时候是双向绑定，即会生成teacherQuery中的值
            //所以清空操作只需要把条件查询的对象清空即可
            this.teacherQuery = {}
            this.getTeacherList()
           
        },
        teacherDeleteById(id){
            teacher.teacherDeleteById(id).then(response=>{
                this.getTeacherList()
                
            })
            /**
             * 实际上catch在这个前端模板中可以不用写，因为在request文件中进行了错误信息提示代码的封装
             * 如果此处再写一遍则catch会执行两次，在部分浏览器中可能无法正常运行
             */
            // .catch(error=>{      
            //     console.log(error)
            // })
            
        },
        open(id) {
            this.$confirm('此操作将永久删除该成员, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                this.teacherDeleteById(id)
                this.$message({
                    type: 'success',
                    message: '删除成功!'
                });
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消删除'
                });
            });
        }
    }
}
</script>