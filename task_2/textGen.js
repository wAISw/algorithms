const loremIpsum = require('lorem-ipsum');
const fs = require('fs');


// refresh files
const fname = 'text.txt';
const resFileName = 'res.json';
fs.writeFileSync(resFileName, '{}');
fs.writeFileSync(fname, '');

// loremIpsum generator
const output = () => loremIpsum({
  count: parseInt(Math.random() * 10), // Number of words, sentences, or paragraphs to generate.
  units: 'sentences',            // Generate words, sentences, or paragraphs.
  sentenceLowerBound: 5,         // Minimum words per sentence.
  sentenceUpperBound: 10,        // Maximum words per sentence.
  paragraphLowerBound: 1,        // Minimum sentences per paragraph.
  paragraphUpperBound: 2,       // Maximum sentences per paragraph.
  format: 'plain',               // Plain text or html
  random: Math.random * 10000,  // A PRNG function. Uses Math.random by default
});

const getRandom = (min, max) => {
  return parseInt(Math.random() * (max - min + 1)) + min;
};

const genTits = () => {
  let fileRes = JSON.parse(fs.readFileSync('res.json', 'utf8'));
  let size1 = getRandom(0, 25);
  let size2 = getRandom(0, 25);

  const tits = ('('.repeat(size1)) + '(.)(.)' + (')'.repeat(size2));

  if (size1 == size2) {
    if (fileRes[tits])
      fileRes[tits] = fileRes[tits] + 1;
    else
      fileRes[tits] = 1;
  }
  fs.writeFileSync(resFileName, JSON.stringify(fileRes));
  return tits;

};

const getFilesize = (filename) => {
  const stats = fs.statSync(filename);
  const fileSizeInBytes = stats.size;
  return fileSizeInBytes / 1000000.0;
};

const getTitsText = () => {
  return output() + genTits();
};

let i = 0;
const append = () => {
  fs.appendFile(fname, getTitsText(), function (err) {
    if (!err) {
      let size = getFilesize(fname);
      i++;
      if (i < 10000)
        append();
    }
  });
};

append();

