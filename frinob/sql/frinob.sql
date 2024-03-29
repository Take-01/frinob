set names utf8;
set foreign_key_checks=0;

drop database if exists frinob;
create database frinob;
use frinob;

create table user_info(
	id int primary key not null auto_increment comment "ID",
	user_id varchar(16) unique not null comment "ユーザーID",
	password varchar(100) not null comment "パスワード",
	user_name varchar(20) not null comment "ユーザー名",
	email varchar(30) not null comment "メールアドレス",
	regist_date datetime comment "登録日時",
	update_date datetime comment "更新日時"
)
	default charset=utf8
	comment="ユーザー情報テーブル"
;

insert into user_info values
(1, "guest1", "84a5aadfb52a360458afca1d6fec5b4f4d638c8743e471cd0b2e0e524b3224f7", "ゲスト1", "guest1@gmail.com", now(), now()),
(2, "guest2", "c389e7a4be00a29510ae0bb5cd2fed5f8571de68a536990a841246de60c231b5", "ゲスト2", "guest2@gmail.com", now(), now()),
(3, "guest3", "75218ef4817396295191656e9e65b6e32d73eb1c0a739aca185bc78e765e4605", "ゲスト3", "guest3@gmail.com", now(), now());

create table post_info(
	id int primary key not null auto_increment comment "ID",
	writer_id varchar(16) not null comment "投稿者",
	title varchar(30) not null comment "タイトル",
	body varchar(500) not null comment "本文",
	category int not null default 0 comment "カテゴリー",
	image_file_path varchar(100) comment "画像ファイルパス",
	image_file_name varchar(50) comment "画像ファイル名",
	regist_date datetime comment "登録日時",
	update_date datetime comment "更新日時",
	foreign key(writer_id) references user_info(user_id),
	foreign key(category) references category(category_id)
)
	default charset=utf8
	comment="投稿情報テーブル"
;

create table favorite_post_info(
	id int primary key not null auto_increment comment "ID",
	user_id varchar(16) not null comment "ユーザーID",
	post_id int not null comment "投稿記事ID",
	post_tag1 varchar(20) not null default "未分類" comment "投稿記事のタグ1",
	post_tag2 varchar(20) comment "投稿記事のタグ2",
	post_tag3 varchar(20) comment "投稿記事のタグ3",
	post_tag4 varchar(20) comment "投稿記事のタグ4",
	post_tag5 varchar(20) comment "投稿記事のタグ5",
	regist_date datetime comment "登録日時",
	update_date datetime comment "更新日時",
	foreign key(user_id) references user_info(user_id),
	foreign key(post_id) references post_info(id)
)
	default charset=utf8
	comment="お気に入り投稿テーブル"
;

create table favorite_user_info(
	id int primary key not null auto_increment comment "ID",
	user_id varchar(16) not null comment "ユーザーID",
	fav_user_id varchar(16) not null comment "お気に入りユーザーID",
	user_tag1 varchar(20) not null default "未分類" comment "ユーザータグ1",
	user_tag2 varchar(20) comment "ユーザータグ2",
	user_tag3 varchar(20) comment "ユーザータグ3",
	user_tag4 varchar(20) comment "ユーザータグ4",
	user_tag5 varchar(20) comment "ユーザータグ5",
	regist_date datetime comment "登録日時",
	update_date datetime comment "更新日時",
	foreign key(user_id) references user_info(user_id),
	foreign key(fav_user_id) references user_info(user_id)
)
	default charset=utf8
	comment="お気に入りユーザーテーブル"
;

create table category(
	category_id int primary key not null comment "カテゴリーID",
	category_name varchar(20) unique not null comment "カテゴリー名",
	category_description varchar(50) not null comment "カテゴリー説明",
	regist_date datetime comment "登録日時",
	update_date datetime comment "更新日時"
)
	default charset=utf8
	comment="カテゴリーテーブル"
;

insert into category values
(0, "未分類", "未分類", now(), now()),
(1, "生活", "料理、掃除など生活に関すること", now(), now()),
(2, "お金", "貯金、投資、節約などお金に関すること", now(), now()),
(3, "趣味", "趣味に関すること", now(), now()),
(4, "学習", "資格、学校、その他学習に関すること", now(), now()),
(5, "仕事", "仕事に関すること", now(), now());