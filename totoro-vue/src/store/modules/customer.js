const state = {
    userId: '',
    username: '',
    sex: Boolean,
}

const mutations = {
    set_username: (state, username) =>{
      state.username = username
    },
    set_sex: (state, sex) => {
        state.sex = sex
    },
    set_userId: (state, userId) => {
        state.userId = userId
    }
}

export default {
    namespace: true,
    state,
    mutations,
}