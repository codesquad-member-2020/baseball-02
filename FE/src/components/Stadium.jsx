import React from "react";
import { Link } from "react-router-dom";
import { PATH } from "Utils/const";

const Stadium = () => {
	return (
		<>
			<button>
				<Link to={PATH.PLAYER_RECORD}>Player Record ></Link>
			</button>
		</>
	);
};

export default Stadium;
