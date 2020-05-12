import React, { useEffect } from "react";
import { Link } from "react-router-dom";
import { PATH, GAME_START } from "Utils/const";
import BallCount from "./BallCount.jsx";
import { Container, InningInfo, PitchBtn, RecordBtn } from "Styles/Stadium";

const Stadium = () => {
	useEffect(() => {
		drawPlayground();
	}, []);

	const drawPlayground = () => {
		const canvas = document.getElementById("ground");
		const ctx = canvas.getContext("2d");

		ctx.lineWidth = "3";
		ctx.strokeStyle = "#fff";
		ctx.fillStyle = "#fff";

		ctx.translate(375, 250);
		ctx.rotate((45 * Math.PI) / 180);
		ctx.rect(-175, -30, 200, 200);
		ctx.stroke();

		ctx.fillRect(-190, 155, 30, 30);
		ctx.fillRect(-190, -45, 30, 30);
		ctx.fillRect(10, -45, 30, 30);
	};

	return (
		<Container>
			<canvas id="ground" width="545" height="445"></canvas>
			<BallCount ballCount={GAME_START.ballCount} />
			<InningInfo>{`${GAME_START.inningInfo.inning}회${
				GAME_START.inningInfo.half === "first" ? "초" : "말"
			} ${GAME_START.inningInfo.attackOrDefense === "attack" ? "공격" : "수비"}`}</InningInfo>
			<PitchBtn>PITCH</PitchBtn>
			<RecordBtn>
				<Link to={PATH.PLAYER_RECORD}>Player Record ></Link>
			</RecordBtn>
		</Container>
	);
};

export default Stadium;
