function axiosRequest(url,  data,method, headers) {
    return axios({
        url: url,
        data: data,
        method: method||"POST",
        headers: headers,
    }).then((response) => {
        return response.data;
    }).catch((error) => {
        console.error(error);
        return Promise.reject(error);
    });
}