<%@ include file="homenavbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Profile</title>
    <link rel="stylesheet" type="text/css" href="CSS/profile.css">
</head>
<body>
    <div class="profile-container">
        <div class="avatar">
            <% 
                // Randomly pick one avatar from online sources
                String[] onlineAvatars = {
                    "https://i.pravatar.cc/150?img=1",
                    "https://i.pravatar.cc/150?img=2",
                    "https://i.pravatar.cc/150?img=3",
                    "https://i.pravatar.cc/150?img=4",
                    "https://i.pravatar.cc/150?img=5",
                    "https://i.pravatar.cc/150?img=6",
                    "https://i.pravatar.cc/150?img=7"
                };
                int randomAvatarIndex = new java.util.Random().nextInt(onlineAvatars.length);
                String selectedAvatar = onlineAvatars[randomAvatarIndex];
            %>
            <img src="<%= selectedAvatar %>" alt="Profile Avatar">
        </div>
        <div class="details">
            <h1>User Profile</h1>
            <table>
                 <tr>
                    <th>First Name</th>
                    <td>${client.fname}</td>
                </tr>
                <tr>
                    <th>Last Name</th>
                    <td>${client.lname}</td>
                </tr>
                <tr>
                    <th>Email</th>
                    <td>${client.email}</td>
                </tr>
                <tr>
                    <th>Mobile</th>
                    <td>${client.mobile}</td>
                </tr>
                <tr>
                    <th>Gender</th>
                    <td>${client.gender}</td>
                </tr>
                <tr>
                    <th>Date of Birth</th>
                    <td>${client.dob}</td>
                </tr>
                <tr>
                    <th>Location</th>
                    <td>${client.location}</td>
                </tr>
            </table>
        </div>
    </div>
</body>
</html>
