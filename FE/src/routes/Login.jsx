import React from "react";
import { Link } from "react-router-dom";
import { PATH } from "Utils/const";

const Login = () => {
	return (
		<>
			<h1>Login</h1>
			<button>
				<Link to={PATH.TEAM_CHOICE}>LOG IN</Link>
			</button>
		</>
	);
};

export default Login;
