-- users テーブルにデータを挿入
INSERT INTO users (name,email, password) VALUES
( '田中太郎', 'tanaka@mail','password123');
INSERT INTO posts (user_id,message) VALUES
(1,'こんにちは');