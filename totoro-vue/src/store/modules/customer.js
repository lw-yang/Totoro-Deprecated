const state = {
    username: '',
    sex: Boolean,
}

const mutations = {
    set_username: (state, username) =>{
      state.username = username
    },

    set_sex: (state, sex) => {
        state.sex = sex
    }
}

export default {
    namespace: true,
    state,
    mutations,
}