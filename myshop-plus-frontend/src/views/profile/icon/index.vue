<template>
  <div class="components-container">
    <pan-thumb :image="image" />

    <el-button type="primary" icon="el-icon-upload" style="position: absolute;bottom: 15px;margin-left: 40px;" @click="toggleShow()">
      上传头像
    </el-button>

    <image-cropper
      v-model="imageCropperShow"
      field="multipartFile"
      :width="300"
      :height="300"
      :url="url"
      :params="params"
      :headers="headers"
      @crop-success="cropSuccess"
      @crop-upload-success="cropUploadSuccess"
      @crop-upload-fail="cropUploadFail"
    />

  </div>
</template>

<script>
import ImageCropper from 'vue-image-crop-upload'
import PanThumb from '@/components/PanThumb'
import { getToken } from '../../../utils/auth'
import { updateIcon } from '../../../api/profile'
export default {
  name: 'AvatarUpload',
  components: { ImageCropper, PanThumb },
  data() {
    return {
      imageCropperShow: false,
      imageCropperKey: 0,
      image: this.$store.getters.avatar,
      url: process.env.VUE_APP_BASE_API + '/upload/icon',
      params: {
        access_token: getToken()
      },
      headers: {
        smail: '*_~'
      }
    }
  },
  methods: {
    toggleShow() {
      this.imageCropperShow = !this.imageCropperShow
    },
    cropSuccess(image, field) {
      console.log('-------- crop success --------')
      this.image = image
    },
    cropUploadSuccess(jsonData, field) {
      console.log('-------- upload success --------')
      console.log(jsonData)
      console.log('field: ' + field)

      updateIcon({
        username: this.$store.getters.name,
        avatar: jsonData.data.path
      }).then(response => {
        this.imageCropperShow = false
        this.$message({
          message: response.message,
          type: 'success'
        })
        this.$store.dispatch('user/setAvatar', jsonData.data.path)
      }).catch({
      })
    },
    cropUploadFail(status, field) {
      console.log('-------- upload fail --------')
      console.log(status)
      console.log('field: ' + field)
    }
  }
}
</script>

<style scoped>
  .avatar{
    width: 200px;
    height: 200px;
    border-radius: 50%;
  }
</style>
