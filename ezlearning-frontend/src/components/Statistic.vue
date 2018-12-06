<template>
    <div class="row">
        <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
            <img src="icons/StatisticCourse.png" alt="">
            <div style="display: inline-block">
                <div>{{statistic.course}}+</div>
                <div>Khóa học</div>
            </div>
        </div>
         <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
             <img src="icons/StatisticStudent.png" alt="">
              <div style="display: inline-block">
                <div>{{statistic.student}}}+</div>
                <div>Học viên</div>
            </div>
        </div>
         <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
             <img src="icons/StatisticTeacher.png" alt="">
              <div style="display: inline-block">
                <div>{{statistic.teacher}}+</div>
                <div>Giảng viên</div>
            </div>
        </div>
    </div>
</template>