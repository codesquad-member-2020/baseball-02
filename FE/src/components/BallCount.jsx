import React from "react";
import { BallCountContainer, BallBox, LightContainer, Light } from "Styles/BallCount";

const BallCount = ({ ballCount }) => {
	const updateBallCount = (num) => {
		return (
			<LightContainer>
				{Array(num)
					.fill(1)
					.map((el, i) => (
						<Light key={el + i}></Light>
					))}
			</LightContainer>
		);
	};

	return (
		<BallCountContainer>
			<BallBox>
				<span>S</span>
				{updateBallCount(ballCount.strike)}
			</BallBox>
			<BallBox>
				<span>B</span>
				{updateBallCount(ballCount.ball)}
			</BallBox>
			<BallBox>
				<span>O</span>
				{updateBallCount(ballCount.out)}
			</BallBox>
		</BallCountContainer>
	);
};

export default BallCount;
