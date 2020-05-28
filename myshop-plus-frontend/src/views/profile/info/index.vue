<template>
  <div class="app-container">
    <el-form
      ref="form"
      v-loading="formLoading"
      :model="form"
      label-width="120px"
      :data="form"
      element-loading-text="加载中...."
    >
      <el-form-item>
        <el-input v-model="form.id" type="hidden" />
      </el-form-item>
      <el-form-item label="用户名:">
        <el-input v-model="form.username" :disabled="true" />
      </el-form-item>
      <el-form-item label="邮箱:">
        <el-input v-model="form.email" />
      </el-form-item>
      <el-form-item label="昵称:">
        <el-input v-model="form.nickName" />
      </el-form-item>
      <el-form-item label="创建时间:">
        <el-input v-model="form.createTime" :disabled="true" />
      </el-form-item>
      <el-form-item label="登录时间:">
        <el-input v-model="form.loginTime" :disabled="true" />
      </el-form-item>
      <el-form-item label="是否启用">
        <el-radio-group v-model="form.status">
          <el-radio :label="0">禁用</el-radio>
          <el-radio :label="1">启用</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { getUserInfo, updateUserInfo } from '../../../api/profile'

export default {
  name: 'ProfileInfo',
  data() {
    return {
      formLoading: true,
      form: {
        id: '',
        username: '',
        email: '',
        nickName: '',
        note: '',
        createTime: '',
        loginTime: '',
        status: ''
      }
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      getUserInfo(this.$store.getters.name).then(response => {
        this.form = response.data
        this.formLoading = false
      })
    },
    onSubmit() {
      this.formLoading = true
      updateUserInfo(this.form).then(response => {
        this.formLoading = false
        this.$message({
          message: response.message,
          type: 'success'
        })
      }).catch(() => {
        this.formLoading = false
      })
    }
  }
}
</script>
<style scoped>
.line{
  text-align: center;
}
</style>
