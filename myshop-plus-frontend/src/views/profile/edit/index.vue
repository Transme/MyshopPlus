<template>
  <div class="app-container">
    <el-form
      ref="form"
      v-loading="formLoading"
      :model="form"
      label-width="120px"
      :data="form"
      element-loading-text="加载中....."
    >
      <el-form-item>
        <div class="content">
          <span class="svg-container">
            <svg-icon icon-class="user" />
          </span>
          <el-input
            ref="username"
            v-model="form.username"
            :disabled="true"
            name="username"
            type="text"
            tabindex="1"
            auto-complete="on"
          />
        </div>
      </el-form-item>
      <el-form-item prop="password">
        <div class="content">
          <span class="svg-container">
            <svg-icon icon-class="password" />
          </span>
          <el-input
            :key="passwordType"
            ref="password"
            v-model="form.password"
            :type="passwordType"
            placeholder="密码"
            name="password"
            tabindex="2"
            auto-complete="on"
            @keyup.enter.native="handleLogin"
          />
          <span class="show-pwd" @click="showPwd">
            <svg-icon :icon-class="passwordType === 'password' ? 'eye' : 'eye-open'" />
          </span>
        </div>
      </el-form-item>
      <el-button :loading="loading" type="primary" style="width:78%;margin-bottom:30px;margin-left:9.5%" @click.native.prevent="handleLogin">修改</el-button>
    </el-form>
  </div>
</template>

<script>
import { updatePassword } from '../../../api/profile'

export default {
  name: 'ModifiedPassword',
  data() {
    const validatePassword = (rule, value, callback) => {
      if (value.length < 6) {
        callback(new Error('The password can not be less than 6 digits'))
      } else {
        callback()
      }
    }
    return {
      formLoading: true,
      form: {
        username: '',
        password: ''
      },
      loginRules: {
        password: [{ required: true, trigger: 'blur', validator: validatePassword }]
      },
      passwordType: 'password'
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.form.username = this.$store.getters.name
      this.formLoading = false
    },
    showPwd() {
      if (this.passwordType === 'password') {
        this.passwordType = ''
      } else {
        this.passwordType = 'password'
      }
      this.$nextTick(() => {
        this.$refs.password.focus()
      })
    },
    handleLogin() {
      this.$refs.form.validate(valid => {
        if (valid) {
          this.formLoading = true
          updatePassword(this.form).then(response => {
            this.formLoading = false
            this.$message({
              message: response.message,
              type: 'success'
            })
          }).catch(() => {
            this.formLoading = false
          })
        } else {
          console.log('error submit!!')
          return false
        }
      })
    }
  }
}
</script>

<style lang="scss">
/* reset element-ui css */
.app-container {
  min-height: 100%;
  width: 100%;
  overflow: hidden;
  justify-content: center;
  justify-items: center;
  .el-input {
    display: inline-block;
    height: 47px;
    width: 85%;

    input {
      -webkit-appearance: none;
      border-radius: 0px;
      padding: 12px 5px 12px 15px;
      height: 47px;
    }
  }
  .el-form-item {
    border-radius: 5px;
    color: #454545;
  }
}
</style>

<style lang="scss" scoped>
$dark_gray:#889aa4;
$light_gray:#eee;

.login-container {
  min-height: 100%;
  width: 100%;
  overflow: hidden;

  .login-form {
    position: relative;
    width: 520px;
    max-width: 100%;
    padding: 160px 35px 0;
    margin: 0 auto;
    overflow: hidden;
  }

  .tips {
    font-size: 14px;
    color: #fff;
    margin-bottom: 10px;

    span {
      &:first-of-type {
        margin-right: 16px;
      }
    }
  }

  .svg-container {
    padding: 6px 5px 6px 15px;
    color: $dark_gray;
    vertical-align: middle;
    width: 30px;
    display: inline-block;
  }

  .title-container {
    position: relative;

    .title {
      font-size: 26px;
      color: $light_gray;
      margin: 0px auto 40px auto;
      text-align: center;
      font-weight: bold;
    }
  }

  .show-pwd {
    position: absolute;
    right: 10px;
    top: 7px;
    font-size: 16px;
    color: $dark_gray;
    cursor: pointer;
    user-select: none;
  }
}
</style>
