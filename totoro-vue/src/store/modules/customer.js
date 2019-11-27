const state = {
    username: '',
}

const mutations = {
    set_username: (state, username) =>{
      state.username = username
    },
}

export default {
    namespace: true,
    state,
    mutations,
}