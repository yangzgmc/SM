app.config(function($routeProvider){
        $routeProvider
            .when("/studentManage",{templateUrl: "views/student.html",controller:"StudentController"})
            .when("/schoolManage",{templateUrl: "views/class.html",controller:"ClassController"})
            .when("/teacherManage",{templateUrl: "views/teacher.html",controller:"TeacherController"})
            .when("/courseManage",{templateUrl: "views/course.html",controller:"CourseController"})
            .when("/recommendBooks",{templateUrl: "views/book.html",controller:"BookController"})
            .when("/payManage",{templateUrl: "views/pay.html",controller:"PayController"})
            .when("/studyManage",{templateUrl: "views/score.html",controller:"ScoreController"})
            .when("/parentStudy",{templateUrl: "views/parent.html",controller:"ParentController"})
            .when("/newsManage",{templateUrl: "views/news.html",controller:"NewsController"})
            .otherwise({templateUrl:"views/student.html"})
    });
