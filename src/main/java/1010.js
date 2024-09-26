console.log("hello");
console.log("hello");
console.log("hello");
console.log("hello");
console.log("hello");


                                      const { Worker } = require('worker_threads');

const worker = new Worker(path.join(__dirname, 'worker.js'));

// Worker에게 메시지 보내기
worker.postMessage('');

// Worker로부터 메시지 받기
worker.on('message', (message) => {
  console.log('Received from worker:', message);
});

// 에러 처리
worker.on('error', (error) => {
  console.error('Worker error:', error);
});

// Worker 종료 시
worker.on('exit', (code) => {
  if (code !== 0)
    console.log(`Worker stopped with exit code ${code}`);
});
