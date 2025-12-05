-- 修复users表结构，移除Spring Security自动添加的字段
-- 注意：执行前请备份数据库

-- 检查表结构
\d users;

-- 如果表中有Spring Security字段，删除它们
-- 注意：这些字段可能是Hibernate自动创建的

-- 删除可能存在的安全相关字段（如果它们存在）
DO $$
BEGIN
    -- 检查并删除列
    IF EXISTS (SELECT 1 FROM information_schema.columns WHERE table_name = 'users' AND column_name = 'account_non_expired') THEN
        ALTER TABLE users DROP COLUMN account_non_expired;
    END IF;
    
    IF EXISTS (SELECT 1 FROM information_schema.columns WHERE table_name = 'users' AND column_name = 'account_non_locked') THEN
        ALTER TABLE users DROP COLUMN account_non_locked;
    END IF;
    
    IF EXISTS (SELECT 1 FROM information_schema.columns WHERE table_name = 'users' AND column_name = 'credentials_non_expired') THEN
        ALTER TABLE users DROP COLUMN credentials_non_expired;
    END IF;
    
    IF EXISTS (SELECT 1 FROM information_schema.columns WHERE table_name = 'users' AND column_name = 'enabled') THEN
        ALTER TABLE users DROP COLUMN enabled;
    END IF;
END $$;

-- 重新创建正确的表结构（如果需要）
-- DROP TABLE IF EXISTS users CASCADE;
-- CREATE TABLE users (
--     id SERIAL PRIMARY KEY,
--     username VARCHAR(50) NOT NULL UNIQUE,
--     email VARCHAR(100) NOT NULL UNIQUE,
--     password VARCHAR(255) NOT NULL,
--     created_at TIMESTAMP DEFAULT NOW()
-- );

-- 验证表结构
\d users;