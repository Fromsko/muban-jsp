<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>哎呀！出错了 😱</title>
    <link rel="stylesheet" href="<c:url value="/assets/css/tailwind.output.css"/>">
    <style>
        .float-up-down {
            animation: floatUpDown 2s infinite ease-in-out;
        }

        @keyframes floatUpDown {
            0%, 100% {
                transform: translateY(0);
            }
            50% {
                transform: translateY(-20px);
            }
        }

        .code-editor {
            background-color: #3a3f3f;
            border: 1px solid #e1e5ed;
            padding: 1rem;
            border-radius: 0.25rem;
            overflow-x: auto;
            white-space: pre-wrap;
        }
    </style>
</head>
<body>
<div class="min-h-screen flex items-center justify-center bg-gradient-to-r from-pink-500 via-red-500 to-yellow-500">
    <div class="container mx-auto text-center select-none">
        <div class="mb-8">
            <span class="text-9xl text-white float-up-down">😢</span>
        </div>
        <h1 class="text-6xl font-bold text-white mb-4">500</h1>
        <pre class="code-editor w-2/4 bg-gray-300 mx-auto rounded-2xl text-green-500 select-text">
            <%=exception%>
        </pre>
        <a href="<c:url value="/"/>" class="error-href-500">BackHome</a>
    </div>
</div>
</body>
</html>
