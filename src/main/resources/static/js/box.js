/**
 *
 */

// window.onload = function () {
//   fetch("/api/boxOffice/box")
//     .then((response) => {
//       if (!response.ok) {
//         throw new Error("가져올 데이터 없음");
//       }
//       return response.json();
//     })
//     .then((data) => {
//       const fwBolderElements = document.querySelectorAll(".fw-bolder");

//       for (let i = 0; i < data.length; i++) {
//         const movieData = data[i];
//         const fwBolderElement = fwBolderElements[i];
//         console.log(movieData);
//         fwBolderElement.innerHTML = `
//           <h5>${movieData.rank} : 위</h5>
//           <h5>${movieData.movieNm}</h5>
//           <h5>누적관객수 : ${movieData.audiAcc}</h5>
//           <h5>개봉일 : ${movieData.openDt}</h5>
//         `;
//       }
//     })
//     .catch((error) => console.log(error));
// };

// const detailBtn = document.querySelectorAll(".btn btn-outline-dark mt-auto");

// fetch("/api/movieDetail", {
//   method: "post",
//   headers: {
//     "content-type": "application/json",
//   },
//   body: JSON.stringify({ movieTitle, releaseDate }),
// })
//   .then((response) => {
//     if (!response.ok) {
//       throw new Error("가져올 데이터 없음");
//     }
//     return response.json();
//   })
//   .then((data) => console.log(data))
//   .catch((error) => console.log(error));
