<template>
<div>
    <div v-for="course in courseBanner" :key="course.id">
    <img src="../assets/pics/banner.png" alt="">
        <div>
            {{course.catname}}
        </div>
        <div>
            {{course.name}}
        </div>
        <div >
           
            <img src="../assets/pics/teacher.png" alt="" style="display:inline-block">   <!-- load hình giáo viên -->
            <div style="display:inline-block">{{course.teachername}}</div>
        </div>
        <button>ĐĂNG KÝ NGAY</button>
    </div>
</div>
</template>
