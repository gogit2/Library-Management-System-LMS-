DROP SCHEMA IF EXISTS `LMS`;
CREATE SCHEMA `LMS`;
use `LMS`;

DROP TABLE IF EXISTS `lib_admin`;

CREATE TABLE `lib_admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `full_name` varchar(128) DEFAULT NULL,
  `phone` varchar(14) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `member_lib`;

CREATE TABLE `member_lib` (
  `member_id` int(11) NOT NULL AUTO_INCREMENT,
  `full_name` varchar(128) DEFAULT NULL,
  `phone` varchar(14) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(128) DEFAULT NULL,
  `ISBN` int(13) DEFAULT NULL,
  `category` varchar(24) DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

CREATE TABLE Member_Book(
	MemberID INT(11) NOT NULL,
	BooKId INT(11) NOT NULL,
	FOREIGN KEY (MemberID) REFERENCES member_lib(member_id),
	FOREIGN KEY (BookID) REFERENCES book(book_id),
	UNIQUE (MemberID, BookID)
);