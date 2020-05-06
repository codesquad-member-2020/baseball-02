const path = require("path");
const HtmlWebPackPlugin = require("html-webpack-plugin");

module.exports = {
	resolve: {
		alias: {
			Components: path.resolve(__dirname, "./src/components/"),
			Styles: path.resolve(__dirname, "./src/styles/"),
		},
	},
	module: {
		rules: [
			{
				test: /\.(js|jsx)$/,
				exclude: /node_modules/,
				loader: "babel-loader",
			},
			{
				test: /\.html$/,
				use: [
					{
						loader: "html-loader",
					},
				],
			},
		],
	},
	plugins: [
		new HtmlWebPackPlugin({
			template: "./src/index.html",
			filename: "./index.html",
		}),
	],
};