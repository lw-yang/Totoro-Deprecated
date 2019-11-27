<template>
    <div>
        <van-row type="flex " justify="space-between">
            <van-col span="24">
                <div id="header">TODO</div>
            </van-col>
        </van-row>

        <div class="flexDiv">
            <div id="sidebar">
                <van-sidebar style="width: 5.8rem" v-model="activeKey">

                    <van-sidebar-item v-for="(item, index) in categories"
                                      :key="index"
                                      :title="item.name"
                                        @click="ToChildCategories"/>
                </van-sidebar>
            </div>
            <div id="content">
                <div id="image">
                    <van-image
                            width="100%"
                            height="9rem"
                            fit="fill"
                            :src="image"
                    />
                </div>
                <div id="childCategory">
                    <ChildCategory :child-category="childCategories"/>
                </div>
            </div>
        </div>


    </div>
</template>

<script>
    import Vue from 'vue';
    import {Image, Lazyload, List, Sidebar, SidebarItem} from 'vant';
    import {getRootCategories} from "../api/category";
    import {getChildCategories} from "../api/category";
    import ChildCategory from "../components/category/ChildCategory";

    Vue.use(Image);
    Vue.use(Lazyload);
    Vue.use(List);
    Vue.use(Sidebar);
    Vue.use(SidebarItem);


    export default {
        name: "Category",
        components: {ChildCategory},
        data() {
            return {
                activeKey: 0,
                categories: [],
                childCategories: [
                    {"src": "https://img.yzcdn.cn/vant/apple-2.jpg","name":"测试"},
                    {"src": "https://img.yzcdn.cn/vant/apple-2.jpg","name":"测试"},
                    {"src": "https://img.yzcdn.cn/vant/apple-2.jpg","name":"测试"},
                    {"src": "https://img.yzcdn.cn/vant/apple-2.jpg","name":"测试"},
                    {"src": "https://img.yzcdn.cn/vant/apple-2.jpg","name":"测试"},
                    {"src": "https://img.yzcdn.cn/vant/apple-2.jpg","name":"测试"},
                    {"src": "https://img.yzcdn.cn/vant/apple-2.jpg","name":"测试"},
                    {"src": "https://img.yzcdn.cn/vant/apple-2.jpg","name":"测试"},
                    {"src": "https://img.yzcdn.cn/vant/apple-2.jpg","name":"测试"},
                    {"src": "https://img.yzcdn.cn/vant/apple-2.jpg","name":"测试"},
                ],
                image:'https://img.yzcdn.cn/vant/apple-2.jpg',

            };
        },
        methods: {
            ToChildCategories(index){
                let rootCategoryId = this.categories[index].id
                getChildCategories(rootCategoryId).then(res =>{
                    this.childCategories = res.data.data
                }).catch(reason => {console.log(reason)})
            },

        },
        created() {
            getRootCategories().then(res =>{
                this.categories = res.data.data
                this.loading = false
            })
        }
    }
</script>

<style scoped>
    #header {
        height: 2.5rem;
        width: 100%;
        margin: auto;
        background-color: #969799;
        text-align: center;
        line-height: 3rem;
    }
    .flexDiv{
        display: flex;
    }

    #sidebar{
        background-color: #f5f2f0;
        margin-top: 1.5rem;
        flex: 1.2;
        height: 32rem;
    }
    #content{
        flex: 3;
        margin-top: 1.5rem;
        display: flex;
        flex-direction: column;
    }
    #image {
        flex: 1;
        /*background-color: #ff976a;*/
    }
    #childCategory{
        margin-top: .5rem;
        flex: 3;
        height: 21rem;
        overflow: scroll;
    }


</style>