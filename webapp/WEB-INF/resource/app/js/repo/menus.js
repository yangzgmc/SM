angular
    .module("app")
    .factory("menuRepo",function(){
        var menus = [
            {"menu":"学生管理", "route":"#/studentManage"},
            {"menu":"班级管理", "route":"#/schoolManage"},
            {"menu":"教师管理", "route":"#/teacherManage"},
            {"menu":"课程管理", "route":"#/courseManage"},
            {"menu":"推荐书刊", "route":"#/recommendBooks"},
            {"menu":"缴费管理", "route":"#/payManage"},
            {"menu":"学习成绩", "route":"#/studyManage"},
            {"menu":"家长学习", "route":"#/parentStudy"},
            {"menu":"新闻管理", "route":"#/newsManage"}
        ];
        return {
            getMenus:function(){
                return menus;
            }
        }
    });
