import request from '@/utils/request'

export function getUserInfo(username) {
  return request({
    url: '/profile/info/' + username,
    method: 'get'
  })
}

export function updateUserInfo(data) {
  return request({
    url: '/profile/modified/info/',
    method: 'post',
    data
  })
}

export function updateIcon(data) {
  return request({
    url: '/profile/modified/icon/',
    method: 'post',
    data
  })
}

export function updatePassword(data) {
  return request({
    url: '/profile/modified/password/',
    method: 'post',
    data
  })
}
