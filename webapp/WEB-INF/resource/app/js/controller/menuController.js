angular.module("app")
    .controller("menuCtrl",function($scope, menuRepo){
        $scope.currentMenu = "学生管理";    //保存当前的menu值,默认为第一个menu
        //获得菜单选项
        $scope.menus = menuRepo.getMenus();
        //点击menu,获得当前的menu值
        $scope.getCurrentMenu=function(currentMenu){
            $scope.currentMenu = currentMenu.menu;
        }

    });