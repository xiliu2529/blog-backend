# 用户注册/登录 API 使用说明

## API 端点

### 1. 用户注册
- **URL**: `POST /api/auth/register`
- **请求体**:
```json
{
    "username": "testuser",
    "email": "test@example.com",
    "password": "password123"
}
```
- **响应**:
  - 成功: `200 OK` - "用户注册成功，用户ID: 1"
  - 失败: `400 Bad Request` - 错误信息

### 2. 用户登录
- **URL**: `POST /api/auth/login`
- **请求体**:
```json
{
    "username": "testuser",
    "password": "password123"
}
```
- **响应**:
  - 成功: `200 OK`
```json
{
    "token": "eyJhbGciOiJIUzI1NiJ9...",
    "type": "Bearer",
    "userId": 1,
    "username": "testuser"
}
```
  - 失败: `400 Bad Request` - "用户名或密码错误"

### 3. 受保护的接口
- **URL**: `GET /api/protected`
- **Headers**: `Authorization: Bearer <token>`
- **响应**: `200 OK` - "你好，testuser！这是一个受保护的接口"

### 4. 公开接口
- **URL**: `GET /api/public`
- **响应**: `200 OK` - "这是一个公开接口，无需认证"

## 测试示例

### 使用 curl 测试

1. **注册用户**:
```bash
curl -X POST http://localhost:8080/api/auth/register \
-H "Content-Type: application/json" \
-d '{
    "username": "testuser",
    "email": "test@example.com",
    "password": "password123"
}'
```

2. **登录用户**:
```bash
curl -X POST http://localhost:8080/api/auth/login \
-H "Content-Type: application/json" \
-d '{
    "username": "testuser",
    "password": "password123"
}'
```

3. **访问受保护接口**:
```bash
curl -X GET http://localhost:8080/api/protected \
-H "Authorization: Bearer YOUR_JWT_TOKEN"
```

## 验证规则

### 用户注册验证
- 用户名: 3-50个字符，必填
- 邮箱: 有效邮箱格式，必填
- 密码: 6-100个字符，必填

### 用户登录验证
- 用户名: 必填
- 密码: 必填

## JWT Token
- 默认过期时间: 24小时 (86400秒)
- 使用HS256算法签名
- 包含用户ID和用户名信息

## 数据库表结构
系统会自动创建以下表：
- users: 用户表
- categories: 分类表
- articles: 文章表
- comments: 评论表

密码使用BCrypt加密存储。