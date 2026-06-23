 INSERT INTO USERS (login_id, login_pass, type) VALUES
('teacherkono', 'konopass', 0),
('teacherkudo', 'kudopass', 0),
('abe', 'abepass', 1),
('ikeda', 'ikedapass', 1),
('ishii', 'ishiipass', 1),
('inoue', 'inouepass', 1),
('ito', 'itopass', 1),
('kato', 'katopass', 1),
('kimura', 'kimurapass', 1),
('kobayashi', 'kobayashipass', 1),
('saito', 'saitopass', 1),
('sasaki', 'sasakipass', 1),
('sato', 'satopass', 1),
('shimizu', 'shimizupass', 1),
('suzuki', 'suzukipass', 1),
('takahashi', 'takahashipass', 1),
('tanaka', 'tanakapass', 1),
('nakajima', 'nakajimapass', 1),
('nakamura', 'nakamurapass', 1),
('hashimoto', 'hashimotopass', 1),
('hatano', 'hatanopass', 1),
('hamada', 'hamadapass', 1),
('fujita', 'fujitapass', 1),
('fujimoto', 'fujimotopass', 1),
('matsumoto', 'matsumotopass', 1),
('miura', 'miurapass', 1),
('miyamoto', 'miyamotopass', 1),
('morita', 'moritapass', 1),
('yamaguchi', 'yamaguchipass', 1),
('yamada', 'yamadapass', 1),
('yamamoto', 'yamamotopass', 1),
('yamazaki', 'yamazakipass', 1);

 INSERT INTO TEACHERS (user_id, name, grade, class_number) VALUES
(1, '河野 太郎', 1, 1),
(2, '工藤 花子', 1, 2);

INSERT INTO STUDENTS (user_id, name, grade, class_number) VALUES
(3, '阿部', 1, 1),
(4, '池田', 1, 1),
(5, '石井', 1, 1),
(6, '井上', 1, 1),
(7, '伊藤', 1, 1),
(8, '加藤', 1, 1),
(9, '木村', 1, 1),
(10, '小林', 1, 1),
(11, '斎藤', 1, 1),
(12, '佐々木', 1, 1),
(13, '佐藤', 1, 1),
(14, '清水', 1, 1),
(15, '鈴木', 1, 1),
(16, '高橋', 1, 1),
(17, '田中', 1, 1),
(18, '中島', 1, 1),
(19, '中村', 1, 1),
(20, '橋本', 1, 1),
(21, '畑野', 1, 1),
(22, '浜田', 1, 1),
(23, '藤田', 1, 1),
(24, '藤本', 1, 1),
(25, '松本', 1, 1),
(26, '三浦', 1, 1),
(27, '宮本', 1, 1),
(28, '森田', 1, 1),
(29, '山口', 1, 1),
(30, '山田', 1, 1),
(31, '山本', 1, 1),
(32, '山崎', 1, 1);

INSERT INTO PARENTS(student_id) VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10),
(11),
(12),
(13),
(14),
(15),
(16),
(17),
(18),
(19),
(20),
(21),
(22),
(23),
(24),
(25),
(26),
(27),
(28),
(29),
(30);

INSERT INTO ITEMS(item_name) VALUES
('きゅうしょくセット'),
('えのぐセット'),
('すいとう'),
('たいそうふく'),
('あかしろぼうし'),
('うわばき'),
('いろえんぴつ'),
('あまがっぱ');

INSERT INTO ITEM_LISTS(date, grade, class_number, item_id) VALUES
('2026-06-22', 1, 1, 1),
('2026-06-22', 1, 1, 2),
('2026-06-22', 1, 1, 3),
('2026-06-22', 1, 1, 4),
('2026-06-22', 1, 1, 5),
('2026-06-22', 1, 1, 6),
('2026-06-22', 1, 1, 7),
('2026-06-22', 1, 1, 8);

INSERT INTO ITEM_CHECK(student_id, date, item_id, is_checked)
SELECT
    s.id,
    '2026-06-22',
    i.id,
    FALSE
FROM STUDENTS s
CROSS JOIN ITEMS i;

INSERT INTO HW(hw_name) VALUES
('けいさんドリル'),
('かんじドリル'),
('おんどく'),
('にっき'),
('ひらがなれんしゅう'),
('カタカナれんしゅう'),
('こくごプリント'),
('さんすうプリント');

INSERT INTO HW_LISTS(date, hw_range, grade, class_number, homework_id) VALUES
('2026-06-22', '1～3ページ', 1, 1, 1),
('2026-06-22', '5～10ページ', 1, 1, 2),
('2026-06-22', 'きょうかしょP12', 1, 1, 3),
('2026-06-22', 'きょうのできごとをひとつ', 1, 1, 4),
('2026-06-22', 'あ～お', 1, 1, 5),
('2026-06-22', 'カ～コ', 1, 1, 6),
('2026-06-22', 'No.1～3', 1, 1, 7),
('2026-06-22', 'No.1～5', 1, 1, 8);

INSERT INTO HW_CHECK(student_id, date, hw_range, homework_id, is_checked)
SELECT
    s.id,
    h.date,
    h.hw_range,
    h.homework_id,
    FALSE
FROM STUDENTS s
JOIN HW_LISTS h
  ON s.grade = h.grade
 AND s.class_number = h.class_number;

INSERT INTO STAMPS(stamp_name, stamp_url) VALUES
('出席', 'images/syusseki.png'),
('発言', 'images/hatugen.png'),
('挑戦', 'images/chousenn.png'),
('達成', 'images/tassei.png'),
('協力', 'images/kyouryoku.png'),
('その他', 'images/sonota.png');

INSERT INTO REACTIONS(reaction_name, reaction_url)VALUES
('ぴえん', 'images/pien.png'),
('にっこり', 'images/nikkori.png'),
('びっくり', 'images/bikkuri.png'),
('グッド', 'images/good.png'),
('既読', 'images/kidoku.png');

INSERT INTO STAMP_LOG(student_id, stamp_id, text, reaction_id, is_read)VALUES
(1, 1, '', 1, FALSE),
(2, 2, '', 2, FALSE),
(3, 3, '', 3, FALSE),
(4, 4, '', 4, FALSE),
(5, 5, '', 5, FALSE),
(6, 6, '忘れ物が多いです', 5, FALSE);