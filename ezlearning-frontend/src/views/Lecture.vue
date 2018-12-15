<template>
<div>
     <div style="height: 60px; content: ''"></div>
     
    <div class="theater">
        <div class="container-fluid">
            <div class="row" style="padding: 0px;">
                <div class="col-sm-9" style="padding-right: 0px;">
                    <div class="container" style="margin-bottom: 10px;">
                        <div class="row">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-11">
                                <div class="theater-cat">Lập trình</div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-1" style="text-align: right; padding-right: 30px">
                                <img src="/icons/back-white.png" width="15px">
                            </div>
                            <div class="col-sm-11">
                                <div class="theater-title">Nhập môn ngôn ngữ lập trình Javascript</div>
                            </div>
                        </div>
                    </div>
                    <div class="player-ph"></div>
                </div>
                <div class="col-sm-3">
                    <div class="box-content" style="height: 100%; margin-top: 0px; padding: 25px;">
                        <div class="lecture-tab">
                            <div class="container" style="height: 100%;">
                                <div class="row" style="height: 100%;">
                                    <div id="curr-tab" class="col-sm-4 tab tab-enabled">
                                        Bài giảng
                                    </div>
                                    <div id="doc-tab" class="col-sm-4 tab tab-disabled">
                                        Tài liệu
                                    </div>
                                    <div id="cmt-tab" class="col-sm-4 tab tab-disabled">
                                        Bình luận
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!--Curriculum-->

                        <div id="curr" class="tab-content" style="display: block; position: relative; height: 100%;">
                            <div style="height: 100% !important; overflow: hidden;">
                                <div class="scroll-curr">
                                    <div class="chapter" style="margin-top: -3px;">
                                        <div class="row">
                                            <div class="col-sm-10 chapter-title">
                                                Phần 1: Tìm hiểu về Javascript
                                            </div>
                                        </div>
                                    </div>
                                    <div class="chapter">
                                        <div class="row">
                                            <div class="col-sm-12 chapter-title">
                                                Phần 2: Tương tác cơ bản với web
                                            </div>
                                        </div>
                                    </div>
                                    <div class="chapter">
                                        <div class="row">
                                            <div class="col-sm-12 chapter-title">
                                                Phần 3: Thực hành làm ứng dụng nhỏ
                                            </div>
                                        </div>
                                        <div class="lecture">
                                            <span class="lecture-title">
                                                Bài 22: Project: Lời hay ý đẹp
                                            </span>
                                        </div>
                                        <div class="lecture">
                                            <span class="lecture-title">
                                                Bài 23: Project: Quản lý To-do
                                            </span>
                                        </div>
                                    </div>
                                    <div class="chapter">
                                        <div class="row">
                                            <div class="col-sm-12 chapter-title">
                                                Phần 4: Tổng kết
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!--Documents-->

                        <div id="doc" class="tab-content" style="display: none">
                            <div class="container">
                                <div class="row doc-seperator">
                                    <div class="col-sm-2" style="padding: 0px;">
                                        <img src="/icons/lecture-detail/download.png" width="41px">
                                    </div>
                                    <div class="col-sm-10">
                                        <div class="doc-title">Slide bài giảng</div>
                                        <div class="doc-filename">slide-bai1.pptx</div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!--Comments-->

                        <div id="cmt" class="tab-content" style="display: none; position: relative; height: 100%;">

                            <div id="cmt-box" class="cmt-box">
                                <input class="input-normal" type="text" style="width: 75%; height: 32px">
                                <button id="rate-submit" class="big-button" style="height: 32px; margin-left: 10px;">Gửi</button>
                            </div>
                            <div style="height: 100% !important; overflow: hidden;">
                                <div class="scroll-cmt">

                                    <div class="container cmt-seperator" style="padding-left: 0px; padding-right: 0px;">
                                        <div class="row comment-margin">
                                            <div class="col-sm-2">
                                                <img src="/imgs/students/student2.png" class="rater-ava">
                                            </div>
                                            <div class="col-sm-10" style="padding-left: 15px !important;">
                                                <div class="rater-name">Nguyễn Công Thành</div>
                                                <div class="rater-date">2 ngày trước</div>
                                            </div>
                                        </div>
                                        <div class="rater-cmt">
                                            Bài giảng chất lượng, dễ hiểu, mong rằng thầy sẽ có nhiều bài giảng dạy
                                            cao
                                            hơn nữa :v
                                        </div>
                                    </div>
    
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
</template>