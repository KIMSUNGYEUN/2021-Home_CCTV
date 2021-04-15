var nodemailer = require('nodemailer');

var transporter = nodemailer.createTransport({

	  service: 'Gmail',

	  auth: {

	    user: '**************@gmail.com',

	    pass: '*********'

	  }

	});

	

	var timerId;

	

	module.exports.sendEmail = function(file) {

	  if (timerId) return;

	

	  timerId = setTimeout(function() {

	    clearTimeout(timerId);

	    timerId = null;

	  }, 10000);

	

	  console.log('Sendig an Email..');

	

	  var mailOptions = {

	    from: 'HOME_CCTV <********@gmail.com>',

	    to: '*************@gmail.com',

	    subject: '[HOME_CCTV]',

	    html: '<b>Hi</b>,<br/><br/> 경고! 비디오를 확인해주세요<br/><br/> HOME_CCTV : ' + Date() + ' <br/><br/>Dear,<br/><i>Smart Mirror</i>',

	    attachments: [{

	      path: file

	    }]

	  };

	

	  transporter.sendMail(mailOptions, function(error, info) {

	    if (error) {

	      console.log(error);

	    } else {

	      console.log('Message sent: ' + info.response);

	    }

	  });

}



출처: https://jeongchul.tistory.com/433 [Jeongchul]
