<template>
  <div style="position: relative;">
    <div style="height: 60px; content: ''"></div>

    <!--Cover-->
    <div class="profile-cover">
      <div class="container" style="height: 100%;">
        <div class="row" style="height: 100%;">
            <ProfileInfo/>
            <SettingProfile/>
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

        <!--Payment history-->
        <TransactionHistory/>
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
