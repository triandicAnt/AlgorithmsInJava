package nlp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Arrays;

import opennlp.tools.chunker.ChunkerME;
import opennlp.tools.chunker.ChunkerModel;
import opennlp.tools.cmdline.PerformanceMonitor;
import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.cmdline.postag.POSModelLoader;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.util.Span;


public class SentenceDetector {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
//			sentenceDetector();
//			tokenizer();
//			findNames();
//			posTagger();
			sentenceParser();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * Sentence Detector
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public static void sentenceDetector() throws InvalidFormatException,IOException{
		InputStream is = new FileInputStream("/home/sud/Downloads/nlp_bin/en-sent.bin");
		String paragraph = "Hello ! How are you.";
		SentenceModel model = new SentenceModel(is);
		SentenceDetectorME sdetector = new SentenceDetectorME(model);
		String sentences [] = sdetector.sentDetect(paragraph);
		System.out.println(Arrays.toString(sentences));
	}
	/**
	 * Tokenizer
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public static void tokenizer()throws InvalidFormatException, IOException{
		InputStream io = new FileInputStream("/home/sud/Downloads/nlp_bin/en-token.bin");
		TokenizerModel tm = new TokenizerModel(io);
		TokenizerME t = new TokenizerME(tm);
		String tokens[] = t.tokenize("Hi. How are you? This is Mike.");
		System.out.println(Arrays.toString(tokens));
	}
	/**
	 * Name Finder
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public static void findNames() throws InvalidFormatException, IOException{
		InputStream is = new FileInputStream("/home/sud/Downloads/nlp_bin/en-ner-person.bin");
		TokenNameFinderModel model = new TokenNameFinderModel(is);
		is.close();
		NameFinderME nameFinder = new NameFinderME(model);
		String [] sentences = new String[]{
				"Mike",
			    "is",
			    "a",
			    "Good",
			    "Bob"
			};
		Span nameSpan [] = nameFinder.find(sentences);
		System.out.println(Arrays.toString(nameSpan));
		for(Span s: nameSpan)
			System.out.println(s.toString());	
	}
	/**
	 * POS Tagging
	 * Chunker
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public static void posTagger()throws InvalidFormatException, IOException{
		POSModel pm = new POSModelLoader().load(new File("/home/sud/Downloads/nlp_bin/en-pos-maxent.bin"));
		PerformanceMonitor perfMon = new PerformanceMonitor(System.err,"sent");
		POSTaggerME  tagger = new POSTaggerME(pm);
		String input = "Hi. How are you? Preety good !!";
		ObjectStream<String> lineStream = new PlainTextByLineStream(
				new StringReader(input));
		perfMon.start();
		String line;
		String whiteSpaceTokenizedLine [] = null;
		String [] tags = null;
		while((line=lineStream.read())!=null){
			whiteSpaceTokenizedLine  = WhitespaceTokenizer.INSTANCE.tokenize(line);
			tags = tagger.tag(whiteSpaceTokenizedLine);
			POSSample sample = new POSSample(whiteSpaceTokenizedLine, tags);
			
			System.out.println(sample.toString());
			perfMon.incrementCounter();
		}
		perfMon.stopAndPrintFinalResult();
		// Chunker
		InputStream is = new FileInputStream("/home/sud/Downloads/nlp_bin/en-chunker.bin");
		ChunkerModel cm = new ChunkerModel(is);
		ChunkerME chunkerME = new ChunkerME(cm);
		String results [] = chunkerME.chunk(whiteSpaceTokenizedLine, tags);
		System.out.println(Arrays.toString(results));
		Span [] s = chunkerME.chunkAsSpans(whiteSpaceTokenizedLine,tags);
		System.out.println(Arrays.toString(s));
		
	}
	public static void sentenceParser()throws InvalidFormatException, IOException{
		InputStream is = new FileInputStream("/home/sud/Downloads/nlp_bin/en-parser-chunking.bin");
		ParserModel model = new ParserModel(is);
		Parser parser = ParserFactory.create(model);
		String sentence = "Its good to learn bout nlp in java";
		Parse[] topParser = ParserTool.parseLine(sentence, parser, 1);
		for (Parse p : topParser)
			p.show();
		is.close();
		
		
	}
}
