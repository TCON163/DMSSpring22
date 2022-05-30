import React, {useState} from 'react';

export default function FileUploadPage(){
	const [selectedFile, setSelectedFile] = useState();
    
	const [isFilePicked, setIsFilePicked] = useState(false);

	const changeHandler = (event) => {
		setSelectedFile(event.target.files[0]);
		setIsFilePicked(true);

        console.log(selectedFile);
       
	};

    function fileToByteArray(file) {
        return new Promise((resolve, reject) => {
            try {
                let reader = new FileReader();
                let fileByteArray = [];
                reader.readAsArrayBuffer(file);
                reader.onloadend = (evt) => {
                    if (evt.target.readyState === FileReader.DONE) {
                        let arrayBuffer = evt.target.result,
                            array = new Uint8Array(arrayBuffer);
                        for (var byte of array) {
                            fileByteArray.push(byte);
                        }
                    }
                    resolve(fileByteArray);
                }
            }
            catch (e) {
                reject(e);
            } 
        })
    }

   

   

	async function handleSubmission(){


        

        let byteArray = await fileToByteArray(selectedFile);
        const data = {
            "fileName":selectedFile.name,
            "fileType": selectedFile.type,
            "data": byteArray
        };

        console.log(data)

		fetch(
			'http://localhost:8080/api/v1/upload',
			{
				method: 'POST',
                headers:{
                    'Content-Type': 'application/json'
                },
				body: JSON.stringify(data),
			}
		)
			.then((response) => response.json())
			.then((result) => {
				console.log('Success:', result);
			})
			.catch((error) => {
				console.error('Error:', error);
			});
	};

    const print = ()=> {
        console.log(selectedFile)
    }

    const download =()=>{
        fetch("http://localhost:8080/api/v1/file/1").then(response => response.blob())
        .then(data=>{
  
            const url = window.URL.createObjectURL(data);
            const a = document.createElement('a');
            a.style.display = 'none';
            a.href = url;
            a.download = "pdf.pdf";
            document.body.appendChild(a);
            a.click();
            window.URL.revokeObjectURL(url);
            alert("your file has downloaded!")
        })
        .catch((err)=>{
            alert("oh no!");
            console.log(err);
        } )
    }


	return(
   <div>
			<input type="file" name="file" onChange={changeHandler} />
			{isFilePicked ? (
				<div>
					<p>Filename: {selectedFile.name}</p>
					<p>Filetype: {selectedFile.type}</p>
					<p>Size in bytes: {selectedFile.size}</p>
					<p>
						lastModifiedDate:{' '}
						{selectedFile.lastModifiedDate.toLocaleDateString()}
					</p>
				</div>
			) : (
				<p>Select a file to show details</p>
			)}
			<div>
				<button onClick={handleSubmission}>Submit</button>
                <br/>
                <br/>
                <button onClick={print}>print file</button>
                <br/>
                <br/>
                <button onClick={download}>download</button>

                <a href='http://localhost:8080/api/v1/file/1' download id="download">download 2</a>
			</div>
		</div>
	);
}