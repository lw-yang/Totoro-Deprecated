const state = {
    username: '',
    token: ''
}

const mutations = {
    set_token: (state, token) =>{
        state.token = token
    },
    set_username: (state, username) =>{
      state.username = username
    }
}

export default {
    namespace: true,
    state,
    mutations,
}