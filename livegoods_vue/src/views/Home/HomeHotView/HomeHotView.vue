<template>
  <div class="hotproduct">
    <h3>{{ title }}</h3>
    <div class="hot-container">
      <ul class="clear-fix">
          <li v-for='(item,index) in hotData' :key='index'>
              <a :href='item.link'>
                <img :src='item.img' :alt='item.title' />
                <span>{{item.title}}</span>
            </a>
          </li>
      </ul>
    </div>
  </div>
</template>
<script>
export default {
    name:'HomeHotView',
    data(){
        return{

        }
    },
    props:['title','hotData']
}
</script>
<style lang="less" scoped>
.hotproduct {
  h3 {
    margin-top: 10px;
    font-size: 12px;
    font-weight: normal;
    text-align: center;
  }
  .hot-container {
    padding: 15px;
    background: #fff;
    margin: 10px;
    border-radius: 5px;
    box-shadow: 1px 1px 5px 1px #e1e1e1;
    ul {
      li {
        width: 25%;
        overflow: hidden;
        padding: 5px;
        float: left;
        a {
          img {
            width: 72px;
	    height: 72px;
	    border-radius: 50%;
	    overflow: hidden;
          }
          span {
            display: block;
            text-align: center;
            font-size: 12px;
          }
        }
      }
    }
  }
}
</style>