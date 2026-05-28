<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Java Hub Dashboard</title>

    <!-- GOOGLE FONT -->
    <link href="https://fonts.googleapis.com/css2?family=Orbitron:wght@400;600;800&family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">

    <!-- FONT AWESOME -->
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"/>

    <style>

        *{
            margin:0;
            padding:0;
            box-sizing:border-box;
        }

        body{
            height:100vh;
            overflow:hidden;
            display:flex;
            justify-content:center;
            align-items:center;
            color:white;
            font-family:'Poppins', sans-serif;

            background:
                    radial-gradient(circle at top left,#0f172a,#050505 40%),
                    radial-gradient(circle at bottom right,#111827,#050505 40%);
        }

        /* GRID BACKGROUND */

        body::before{
            content:"";
            position:absolute;
            width:100%;
            height:100%;

            background:
                    linear-gradient(rgba(255,255,255,0.03) 1px, transparent 1px),
                    linear-gradient(90deg, rgba(255,255,255,0.03) 1px, transparent 1px);

            background-size:50px 50px;
            animation:gridMove 10s linear infinite;
        }

        @keyframes gridMove{
            from{
                transform:translateY(0px);
            }
            to{
                transform:translateY(50px);
            }
        }

        /* SIDEBAR */

        .sidebar{
            position:fixed;
            left:0;
            top:0;
            width:230px;
            height:100%;
            padding:40px 20px;

            background:rgba(255,255,255,0.03);
            backdrop-filter:blur(12px);

            border-right:1px solid rgba(255,255,255,0.08);

            z-index:100;
        }

        .sidebar h2{
            font-family:'Orbitron', sans-serif;
            color:#00f5ff;
            margin-bottom:50px;
            font-size:28px;
        }

        .sidebar a{
            display:block;
            margin:25px 0;
            text-decoration:none;
            color:#aaa;
            font-size:16px;
            transition:0.3s;
        }

        .sidebar a:hover{
            color:#00f5ff;
            transform:translateX(10px);
        }

        /* DASHBOARD */

        .dashboard{
            width:85%;
            max-width:1200px;
            margin-left:220px;
            position:relative;
            z-index:10;
        }

        /* TITLE */

        .title{
            text-align:center;
            margin-bottom:60px;
        }

        .title h1{
            font-size:70px;
            font-family:'Orbitron', sans-serif;

            background:linear-gradient(90deg,#00f5ff,#8b5cf6,#00ff99);

            -webkit-background-clip:text;
            -webkit-text-fill-color:transparent;

            letter-spacing:5px;

            text-shadow:
                    0 0 20px rgba(0,255,255,0.5),
                    0 0 40px rgba(139,92,246,0.3);
        }

        .title p{
            margin-top:12px;
            color:#888;
            letter-spacing:3px;
            font-size:14px;
        }

        /* CARDS */

        .container{
            display:grid;
            grid-template-columns:repeat(auto-fit,minmax(250px,1fr));
            gap:30px;
        }

        .card{
            position:relative;
            height:220px;

            border-radius:25px;
            overflow:hidden;

            cursor:pointer;

            background:rgba(255,255,255,0.04);

            border:1px solid rgba(255,255,255,0.08);

            backdrop-filter:blur(15px);

            transition:0.4s;
        }

        .card:hover{
            transform:translateY(-12px) scale(1.03);

            border:1px solid rgba(255,255,255,0.3);

            box-shadow:
                    0 0 20px rgba(255,255,255,0.1),
                    0 0 60px rgba(255,255,255,0.05);
        }

        /* NEON COLORS */

        .card:nth-child(1){
            box-shadow:0 0 20px rgba(0,255,255,0.15);
        }

        .card:nth-child(2){
            box-shadow:0 0 20px rgba(168,85,247,0.15);
        }

        .card:nth-child(3){
            box-shadow:0 0 20px rgba(34,197,94,0.15);
        }

        .card:nth-child(4){
            box-shadow:0 0 20px rgba(249,115,22,0.15);
        }

        .card:nth-child(5){
            box-shadow:0 0 20px rgba(59,130,246,0.15);
        }

        .card:nth-child(6){
            box-shadow:0 0 20px rgba(236,72,153,0.15);
        }

        /* CARD CONTENT */

        .content{
            position:absolute;
            width:100%;
            height:100%;

            display:flex;
            flex-direction:column;
            justify-content:center;
            align-items:center;

            z-index:2;
        }

        .icon{
            font-size:55px;
            margin-bottom:15px;
            transition:0.3s;
        }

        .card:hover .icon{
            transform:scale(1.2) rotate(8deg);
        }

        .content h2{
            font-size:26px;
            letter-spacing:2px;
            margin-bottom:10px;
            font-family:'Orbitron', sans-serif;
        }

        .content p{
            color:#999;
            font-size:13px;
            letter-spacing:1px;
        }

        /* BUTTON */

        button{
            margin-top:20px;

            padding:10px 24px;

            border:none;
            border-radius:12px;

            background:rgba(255,255,255,0.08);

            color:white;

            cursor:pointer;

            font-weight:600;

            transition:0.3s;
        }

        button:hover{
            background:#00f5ff;
            color:black;
            transform:scale(1.05);
        }

        /* FLOATING LIGHTS */

        .particle{
            position:absolute;
            width:250px;
            height:250px;

            background:#00f5ff;

            border-radius:50%;

            filter:blur(120px);

            opacity:0.15;

            top:10%;
            right:10%;
        }

        .particle.two{
            background:#8b5cf6;

            bottom:10%;
            left:20%;
        }

    </style>

</head>

<body>

<!-- PARTICLES -->

<div class="particle"></div>
<div class="particle two"></div>

<!-- SIDEBAR -->

<div class="sidebar">

    <h2>JAVA HUB</h2>

    <a href="#">🏠 Home</a>
    <a href="#">🍪 Cookie</a>
    <a href="#">⏳ Time</a>
    <a href="#">⚡ Dashboard</a>
    <a href="#">🔐 Session</a>
    <a href="#">📈 Counter</a>

</div>

<!-- DASHBOARD -->

<div class="dashboard">

    <div class="title">

        <h1>JAVA HUB</h1>

        <p>ADVANCED JAVA TOOL PANEL</p>

    </div>

    <div class="container">

        <!-- CARD 1 -->

        <div class="card" onclick="openTab('hello')">

            <div class="content">

                <div class="icon">
                    <i class="fa-solid fa-hand"></i>
                </div>

                <h2>HELLO</h2>

                <p>Servlet Welcome Page</p>

                <button>Launch Tool →</button>

            </div>

        </div>

        <!-- CARD 2 -->

        <div class="card" onclick="openTab('cookieManager?action=create')">

            <div class="content">

                <div class="icon">
                    <i class="fa-solid fa-cookie-bite"></i>
                </div>

                <h2>COOKIE</h2>

                <p>Cookie Management</p>

                <button>Launch Tool →</button>

            </div>

        </div>

        <!-- CARD 3 -->

        <div class="card" onclick="openTab('datetime')">

            <div class="content">

                <div class="icon">
                    <i class="fa-solid fa-clock"></i>
                </div>

                <h2>TIME</h2>

                <p>Live Date & Time</p>

                <button>Launch Tool →</button>

            </div>

        </div>

        <!-- CARD 4 -->

        <div class="card" onclick="openTab('dashboard')">

            <div class="content">

                <div class="icon">
                    <i class="fa-solid fa-chart-line"></i>
                </div>

                <h2>DASHBOARD</h2>

                <p>Main Control System</p>

                <button>Launch Tool →</button>

            </div>

        </div>

        <!-- CARD 5 -->

        <div class="card" onclick="openTab('sessiontrack')">

            <div class="content">

                <div class="icon">
                    <i class="fa-solid fa-user-shield"></i>
                </div>

                <h2>SESSION</h2>

                <p>User Session Tracking</p>

                <button>Launch Tool →</button>

            </div>

        </div>

        <!-- CARD 6 -->

        <div class="card" onclick="openTab('tool1')">

            <div class="content">

                <div class="icon">
                    <i class="fa-solid fa-chart-column"></i>
                </div>

                <h2>COUNTER</h2>

                <p>Visitor Count Tool</p>

                <button>Launch Tool →</button>

            </div>

        </div>

    </div>

</div>

<script>

    function openTab(url){
        window.open(url, '_blank');
    }

</script>

</body>
</html>