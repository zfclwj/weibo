app.controller('homeCtrl',['$scope','$resource','$location',function($scope,$resource,$location){
	
	var username = getCookie("username");
	console.log("cookies...",username);
	//var extinfo = false;
	if(username=='undefined'){
		$location.path("/signin");
	}
	$scope.showPosts = function() {
		
    	var postResource = $resource('post/show', {}, {query:{method:'GET',isArray:false}});
    	postResource.query({},function(res){
    		$scope.postList = res.data;
    		//$scope.extinfo = true;
    	}, function (res) {
        	console.log("error");
        });
    };
    
    $scope.addPost = function() {
    	var postResource = $resource('post/new', {}, {save:{method:'POST'}});
    	$scope.post.authorName = username;
    	postResource.save({},$scope.post,function (res) {
    		$scope.showPosts();
    	}, function (res) {
        	console.log("error");
        });
    };
    
    $scope.delete1 = function(id) {
    	console.log(id,'...');
    	var postResource = $resource('post/delete/:id', {id:id}, {save:{method:'GET'}});
    	postResource.save({id:id},function (res) {
    		$scope.showPosts();
    	}, function (res) {
        	console.log("error");
        });
    };
    
    $scope.setReplyPostId = function(id){
    	$scope.replyPostId = id;
    }
    $scope.addComment = function() {
    	$scope.comment.cAuthorName = username;
    	$scope.comment.postId=$scope.replyPostId;
    
    	var commentResource = $resource('comment/new', {}, {save:{method:'POST'}});
    	commentResource.save({},$scope.comment,function (res) {
    		$scope.showPosts();
    	}, function (res) {
        	console.log("error");
        });
    };
//赞
    $scope.like = function(id) {
    	console.log(id,'...');
    	var postResource = $resource('post/likes/:id', {id:id}, {save:{method:'GET'}});
    	postResource.save({id:id},function (res) {
    		$scope.showPosts();
    		 
    	}, function (res) {
        	console.log("error");
        });
    };
    //不赞
    $scope.disLike = function(id) {
    	console.log(id,'...');
    	var postResource = $resource('post/disLike/:id', {id:id}, {save:{method:'GET'}});
    	postResource.save({id:id},function (res) {
    		$scope.showPosts();
    		 
    	}, function (res) {
        	console.log("error");
        });
    };
    
    $scope.showPosts();
	
   //$scope.mycalendar().dcalendar();
    $('#mycalendar').dcalendar();	
    //$('clockpicker').clockpicker();
    
}]);