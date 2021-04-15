var http = require('http');

var express = require('express');

var smartmirror = express();

smartmirror.use(express.static(__dirname+"/public"));

http.createServer(smartmirror).listen(9091,function() {

	console.log('server on 9091...');

});

var exec_video = require('child_process').exec;

var exec_photo = require('child_process').exec;

var video_path = __dirname+"/public/video/"+Date.now()+'.h264';

var photo_path = __dirname+"/public/photo/"+Date.now()+'.jpg';

var cmd_video = 'raspivid -o '+video_path+' -t 4000';

var cmd_photo = 'raspistill -o '+photo_path;

exec_video(cmd_video, function(errror, stdout, stderr) {

	console.log('Video Saved : ',video_path);

	require('./mailer').sendEmail(video_path);

});

/*

exec_photo(cmd_photo, function(error, stdout, stderr){

	console.log('Photo Saved : ',photo_path);

	require('./mailer').sendEmail(photo_path);

});

*/

function exit() {

	process.exit();

	

}
