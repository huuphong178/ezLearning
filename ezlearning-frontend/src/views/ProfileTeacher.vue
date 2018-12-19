<template>
    <div>
         <!--Cover-->
    <div>

        <div class="profile-cover">
            <div class="container" style="height: 100%;">
                <div class="row" style="height: 100%;">
                   <ProfileInfo/>
                    <SettingProfile/>
                </div>
            </div>
        </div>

    </div>

    <!--Content-->
    <div>

        <div class="container">

            <!--Course-->
            <div id="course" class="tab-content">
                <div class="tile-container" style="grid-template-rows: 230px;">
                    <ProfileCourseCard/>
                </div>
            </div>

            <!--Teacher Profile-->
            <div id="profile" class="tab-content" style="display: none; padding-top: 30px; padding-bottom: 45px;">
                <div id="tprofile-info">
                    <div class="tprofile-title">
                        Giới thiệu về bạn
                        <button id="tprofile-edit-btn" class="button-white-small" style="margin-left: 30px;">Chỉnh sửa</button>
                    </div>
                    <div>
                        Thầy Phan Văn Luân đã từng làm việc tại FPT với vai trò technical leader, đồng thời là giảng viên
                        đào tạo các khóa fher của FOT.<br>
                        Làm việc tại LINE cũng là team leader đội phát triển ứng dụng Mobile.<br>
                        Là founder của trang web chuyên chia sẻ các kỹ năng lập trình web (website: laptrinh.io).<br>
                        Tham gia và các dự án mã nguồn mở trên thế giới liên quan tới các nền tảng framework như Laravel,
                        lonic Framework, Codeconcept JS.<br>
                        Là một blogger về kỹ thuật chia sẻ hướng dẫn một số thủ thuật lập trình trên trang blog cá nhân
                        (website: blog.petehouston.com).<br>
                    </div>
                </div>
                <div id="tprofile-edit" style="display: none;">
                    <div class="tprofile-title">
                        Giới thiệu về bạn
                        <button id="tprofile-save-btn" class="button-white-small" style="margin-left: 30px;">Lưu</button>
                    </div>
                    <div>
                        <textarea class="input-normal" style="height: auto !important" rows="3" type="text"></textarea>
                    </div>
                </div>
            </div>

        </div>

    </div>
    </div>
</template>

<script>
import ProfileInfo from "@/components/ProfileInfo.vue";
import ProfileCourseCard from "@/components/ProfileCourseCard.vue";
import SettingProfile from "@/components/SettingProfile.vue";
import TransactionHistory from "@/components/TransactionHistory.vue";

export default {
  components: {
    ProfileInfo,
    ProfileCourseCard,
    SettingProfile,
    TransactionHistory
  }
};
</script>