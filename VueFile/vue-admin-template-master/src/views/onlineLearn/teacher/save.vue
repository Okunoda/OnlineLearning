<template>
  <div class="app-container">
    <el-form label-width="120px">
      <el-form-item label="讲师名称" label-width="120px">
        <el-input v-model="teacher.name" />
      </el-form-item>
      <el-form-item label="所属学院">
        <!-- @change="" 可以在选中时调用方法-->
        <el-select
          v-model="teacher.courage"
          clearable
          placeholder="请选择"
          filterable
        >
          <!--
                    数据类型一定要和取出的json中的一致，否则没法回填
                    因此，这里value使用动态绑定的值，保证其数据类型是number
                    -->
          <el-option :value="1" label="电子与信息工程学院" />
          <el-option :value="2" label="人文学院" />
          <el-option :value="3" label="机电学院" />
          <el-option :value="4" label="生命科学学院" />
          <!-- <el-option :value="5" label="建工学院"/>
                    <el-option :value="6" label="外国语学院"/>
                    <el-option :value="7" label="法学院"/>
                    <el-option :value="8" label="马克思主义学院"/> -->
        </el-select>
      </el-form-item>
      <el-form-item label="讲师职位">
        <el-select v-model="teacher.level" clearable placeholder="请选择">
          <!--
                    数据类型一定要和取出的json中的一致，否则没法回填
                    因此，这里value使用动态绑定的值，保证其数据类型是number
                    -->
          <el-option :value="1" label="讲师" />
          <el-option :value="2" label="副教授" />
          <el-option :value="3" label="教授" />
        </el-select>
      </el-form-item>
      <el-form-item label="讲师简介">
        <el-input v-model="teacher.intro" :rows="10" type="textarea" />
      </el-form-item>

      <!-- 讲师头像 -->
      <el-form-item label="讲师头像">
        <!-- 头衔缩略图 -->
        <pan-thumb :image="teacher.avatar" />
        <!-- 文件上传按钮 -->
        <el-button
          type="primary"
          icon="el-icon-upload"
          @click="imagecropperShow = true"
          >更换头像
        </el-button>
        <!--
        v-show：是否显示上传组件
        :key：类似于id，如果一个页面多个图片上传控件，可以做区分
        :url：后台上传的url地址
        @close：关闭上传组件
        @crop-upload-success：上传成功后的回调 -->
        <image-cropper
          v-show="imagecropperShow"
          :width="300"
          :height="300"
          :key="imagecropperKey"
          :url="BASE_API + '/eduoss/fileoss/upload'"
          field="file"
          @close="close"
          @crop-upload-success="cropSuccess"
        />
      </el-form-item>
      <el-form-item>
        <el-button
          :disabled="saveBtnDisabled"
          type="primary"
          @click="saveOrUpdate()"
          >保存</el-button
        >
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import teacherApi from "@/api/teacher";
import ImageCropper from '@/components/ImageCropper'
import PanThumb from '@/components/PanThumb'

export default {
  components: { ImageCropper, PanThumb },
  data() {
    return {
      teacher: {
        name: "",
        avatar: "",
      },
      //是否禁用保存按钮
      saveBtnDisabled: false,
      //上传弹框组件是否显示
      imagecropperShow: false,
      //上传组件的key值
      imagecropperKey: 0,
      //获取env.dev.js中的地址
      BASE_API: process.env.BASE_API,
    };
  },
  created() {
    this.init();
  },
  //监听
  watch: {
    $route(to, from) {
      //路由变化方式，路由发生变化，则方法会执行，此行固定写法
      this.init();
    },
  },
  methods: {
    init() {
      //如果路径中有id值，则回显数据
      if (this.$route.params && this.$route.params.id) {
        //从路径中获取id值
        const id = this.$route.params.id;
        this.getInfo(id);
      } else {
        //如果没有，则清空输入框
        this.teacher = {};
      }
    },
    saveOrUpdate() {
      //根据teacher中是否有id值，有则是更新操作，没有就是添加操作
      if (!this.teacher.id) {
        this.save();
      } else {
        this.update();
      }
    },
    save() {
      teacherApi.addTeacher(this.teacher).then((response) => {
        this.$message({
          type: "success",
          message: "添加成功！",
        });
        //路由跳转，写法较为固定
        this.$router.push({ path: "/teacher/table" });
      });
    },
    update() {
      teacherApi.updateTeacher(this.teacher).then((response) => {
        this.$message({
          type: "success",
          message: "修改成功！",
        });
        //路由跳转，写法较为固定
        this.$router.push({ path: "/teacher/table" });
      });
    },
    getInfo(id) {
      teacherApi
        .getTeacherById(id)
        .then((response) => {
          console.log("getInfo");
          console.log(response);
          this.teacher = response.data.item;
        })
        .catch((error) => {
          console.log("错误");
        });
    },
    //关闭上传弹窗
    close() {
        this.imagecropperShow=false
    },
    //上传成功
    cropSuccess(data){
        this.imagecropperShow = false
        this.teacher.avatar = data.url
        this.imagecropperKey = this.imagecropperKey+1
    }
  },
};
</script>